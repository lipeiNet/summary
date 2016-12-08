package com.lp.summary.others;

/**
 * Created by Administrator on 2016/12/7.
 */
public class AtomicIntegerCompareTest {
    private int value;

    public AtomicIntegerCompareTest(int value){
        this.value = value;
    }

    public synchronized int increase(){
        return value++;
    }
}
