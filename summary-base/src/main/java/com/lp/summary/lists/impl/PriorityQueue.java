package com.lp.summary.lists.impl;

import com.lp.summary.lists.Queue;

/**
 * Created by Administrator on 2017/2/19.
 * 优先级队列
 */
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    private SortedSingleLinkedList<T> list;

    public PriorityQueue() {
        list = new SortedSingleLinkedList<T>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(T x) {
        list.insert(x);
    }

    public T deQueue() {
        return list.remove(0);
    }
}
