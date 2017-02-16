package com.lp.summary.springinaction.aop.impl;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/8.
 * 性能监控
 */
@Component
public class PerformanceMonitoring {
    private static String[] types = { "java.lang.Integer", "java.lang.Double",
            "java.lang.Float", "java.lang.Long", "java.lang.Short",
            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",
            "java.lang.String", "int", "double", "long", "short", "byte",
            "boolean", "char", "float" };
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        String clazzSimpleName = clazz.getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String[] paramNames = this.getFieledsName(this.getClass(), clazzName, methodName);
        System.out.println("clazzName: "+clazzName+", methodName:"+methodName);
        String logContent = writeLogInfo(paramNames, joinPoint);
        System.out.println(logContent);
//        String[] paramNames = getFieldsName(this.getClass(), clazzName, methodName);
//
//        String logContent = writeLogInfo(paramNames, joinPoint);

       /* System.out.println("执行对象：" + joinPoint.getTarget().getClass().getName());
        System.out.println("执行方法：" + joinPoint.getSignature().getName());
        if (!(null == joinPoint.getArgs() || joinPoint.getArgs().length <= 0)) {
            int i = 0;
            for (Object obj : joinPoint.getArgs()) {
                System.out.println("参数" + i + ":" + obj);
                i++;
            }
        }
        long start=System.currentTimeMillis();
        joinPoint.proceed();
        long end=System.currentTimeMillis();
        System.out.println("监听时间为："+(end-start)+"秒");*/
    }

    private  String writeLogInfo(String[] paramNames, ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        boolean clazzFlag = true;
        for(int k=0; k<args.length; k++){
            Object arg = args[k];
            sb.append(paramNames[k]+" ");
            // 获取对象类型
            String typeName = arg.getClass().getName();
            for (String t : types) {
                if (t.equals(typeName)) {
                    sb.append("=" + arg+"; ");
                }
            }
            if (clazzFlag) {
                sb.append(getFieldsValue(arg));
            }
        }
        return sb.toString();
    }
        /**
         * 得到方法参数的名称
         * @param cls
         * @param clazzName
         * @param methodName
         * @return
         * @throws NotFoundException
         */
    protected String[] getFieledsName(Class cls, String clazzName, String methodName) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath=new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc=pool.get(clazzName);
        CtMethod cm=cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr==null){
            return null;
        }
        String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++){
            paramNames[i] = attr.variableName(i + pos); //paramNames即参数名
        }
        return paramNames;
    }
    public  String getFieldsValue(Object obj) {
        Field[] fields=obj.getClass().getDeclaredFields();
        String typeName = obj.getClass().getName();
        for (String t : types) {
            if(t.equals(typeName))
                return "";
        }
        StringBuilder sb=new StringBuilder();
        if (fields!=null && fields.length>0){
            sb.append("【");
            for (Field f:fields){
                f.setAccessible(true);
                for (String str:types){
                    if (f.getType().getName().equals(str)){
                        try {
                            sb.append(f.getName()+"="+f.get(obj)+";");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            sb.append("】");
        }
        return sb.toString();
    }
}
