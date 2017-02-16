package com.lp.summary.others;

import javassist.*;

/**
 * Created by Administrator on 2016/12/21.
 */
public class ClassesTest {
    public static void main(String[] args) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(B.class);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get("com.lp.summary.others.B");
        CtMethod cm = cc.getDeclaredMethod("test");
        String[] aa = Classes.getMethodParamNames(cm);
    }
}
