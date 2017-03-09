package com.lp.summary.lists.impl;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/3/6.
 */
public class HashSet<T> {
    private SingleLinkedList<T>[] table;

    public HashSet(int size) {
        this.table = new SingleLinkedList[Math.abs(size)];
        for (int i = 0; i < table.length; i++) {
            table[i] = new SingleLinkedList<T>();//制造单链表
        }
    }

    public HashSet() {
        this(97);
    }

    private int hash(T x) {
        int key = Math.abs(x.hashCode());
        return key % table.length;
    }

    public void insert(T x) {
        this.table[hash(x)].insert(0, x);
    }

    public void remove(T x) {
        this.table[hash(x)].remove(x);
    }

    public T search(T key) {
        return table[hash(key)].search(key);
    }
}
