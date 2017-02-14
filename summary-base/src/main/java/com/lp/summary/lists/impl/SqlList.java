package com.lp.summary.lists.impl;

import com.lp.summary.lists.IList;

/**
 * Created by Administrator on 2017/2/14.
 * 顺序表的实现
 */
public class SqlList<T> implements IList<T> {
    private Object[] element;
    private int len;

    public SqlList() {
        this(64);
    }

    public SqlList(int size) {
        this.element = new Object[size];
        this.len = 0;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public int length() {
        return this.len;
    }

    public T get(int i) {
        if (i < 0 || i > this.len - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.element[i];
    }

    public void set(int i, T x) {
        if (i < 0 || i > this.len - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (x == null) {
            return;
        }
        this.element[i] = x;
    }

    public void insert(int i, T x) {
        if (i < 0 || i > this.len - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (this.len == this.element.length) {
            Object[] temp = this.element;
            this.element = new Object[2 * this.len];
            for (int m = 0; m < this.len; m++) {
                this.element[m] = temp[m];
            }
        }
        for (int j = i; j <= this.len - 1; j++) {
            this.element[j+1] = this.element[j];
        }
        this.element[i] = x;
        this.len++;
    }
    public void append(T x) {
        this.insert(this.len, x);
    }

    public T remove(int i) {
        if (i < 0 || i > this.len - 1) {
            throw new IndexOutOfBoundsException();
        }
        T temp = (T) this.element[i];
        if (i == this.len - 1) {
            this.element[this.len - 1] = null;
            this.len--;
            return temp;
        }
        for (int j = i; j <= this.len - 1; j++) {
            this.element[j] = this.element[j+1];
        }
        this.len--;
        return temp;
    }

    public void removeAll() {
        this.len=0;
    }

    public T search(T key) {
        return null;
    }
}
