package com.lp.summary.others;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/1/5.
 */
public class D {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(getType(Classes.class));
    }

    public static Object getType(Class c) throws NoSuchFieldException, IllegalAccessException {
        Field f = c.getDeclaredField("TYPE");
        Object obj = f.get(c);
        return obj;
    }
}
