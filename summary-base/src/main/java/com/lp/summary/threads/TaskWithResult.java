package com.lp.summary.threads;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/11/21.
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
