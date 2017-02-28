package com.lp.summary.others;

/**
 * Created by Administrator on 2017/2/23.
 */
public class Singleton {
    private static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public  static void main(String[] args) {
        Singleton a=Singleton.getSingleton();
    }
}
