package com.lp.summary.lists;

/**
 * Created by Administrator on 2017/2/19.
 * 对列接口
 */
public interface Queue<T> {
    /**
     * 验证队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param x
     */
    void enQueue(T x);

    /**
     * 出队
     * @return
     */
    T deQueue();
}
