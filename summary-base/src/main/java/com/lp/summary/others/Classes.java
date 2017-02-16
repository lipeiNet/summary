package com.lp.summary.others;

import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Classes {
    /**
     * <p>
     * 获取方法参数名称
     * </p>
     *
     * @param cm
     * @return
     */
    protected static String[] getMethodParamNames(CtMethod cm) {
        CtClass cc = cm.getDeclaringClass();
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute
                .getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            try {
                throw new Exception(cc.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String[] paramNames = null;
        try {
            paramNames = new String[cm.getParameterTypes().length];
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++) {
            paramNames[i] = attr.variableName(i + pos);
        }
        return paramNames;
    }

    /**
     * 获取方法参数名称，按给定的参数类型匹配方法
     *
     * @param clazz
     * @param method
     * @param paramTypes
     * @return
     */
    public static String[] getMethodParamNames(Class<?> clazz, String method,
                                               Class<?>... paramTypes) {

        ClassPool pool = ClassPool.getDefault();
        CtClass cc = null;
        CtMethod cm = null;
        try {
            cc = pool.get(clazz.getName());

            String[] paramTypeNames = new String[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++)
                paramTypeNames[i] = paramTypes[i].getName();

            cm = cc.getDeclaredMethod(method, pool.get(paramTypeNames));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return getMethodParamNames(cm);
    }

    /**
     * 获取方法参数名称，匹配同名的某一个方法
     *
     * @param clazz
     * @param method
     * @return
     * @throws NotFoundException 如果类或者方法不存在
     * @throws
     */
    public static String[] getMethodParamNames(Class<?> clazz, String method) throws NotFoundException {

        ClassPool pool = ClassPool.getDefault();
        CtClass cc;
        CtMethod cm = null;
        try {
            cc = pool.get(clazz.getName());
            cm = cc.getDeclaredMethod(method);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return getMethodParamNames(cm);
    }
}

