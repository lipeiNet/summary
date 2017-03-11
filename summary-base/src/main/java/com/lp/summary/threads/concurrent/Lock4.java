package com.lp.summary.threads.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lipei on 2017/3/10.
 */
public class Lock4 {
    private List<String> list = new ArrayList();

    public synchronized void add(String s) {
        if (list != null) {
            list.add(s);
        }
    }

    public String getValue() {
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public static void main(String[] args) {
        Lock4 lock4=new Lock4();
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(new Test2(lock4));
        service.execute(new Test2(lock4));
        service.execute(new Test2(lock4));
        service.execute(new Test2(lock4));
        service.execute(new Test2(lock4));
        service.execute(new Test2(lock4));
        service.execute(new Test1(lock4));
        service.execute(new Test1(lock4));
        service.execute(new Test2(lock4));
        service.execute(new Test2(lock4));
        service.shutdown();
    }
}
