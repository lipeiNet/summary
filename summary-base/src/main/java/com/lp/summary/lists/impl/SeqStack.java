package com.lp.summary.lists.impl;

import com.lp.summary.lists.SStack;

/**
 * Created by Administrator on 2017/2/16.
 * 顺序表实现栈
 */
public class SeqStack<T> implements SStack<T> {
    private Object[] elements;
    private int top;//记录栈顶元素位置

    public SeqStack() {
        this(64);
    }

    public SeqStack(int size) {
        this.elements = new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(T x) {
        if (x == null) {
            return;
        }
        if (this.top == this.elements.length - 1) {
            Object[] temp = this.elements;
            this.elements = new Object[2 * this.elements.length * 2];
            for (int i = 0; i < this.top; i++) {
                this.elements[i] = temp[i];
            }
        }
        this.top++;
        this.elements[this.top] = x;
    }

    public T pop() {
        return this.top == -1 ? null : (T) this.elements[this.top];
    }

    public T get() {
        return this.top == -1 ? null : (T) this.elements[this.top];
    }
}
