package com.lp.summary.lists.impl;

import com.lp.summary.lists.Queue;

/**
 * Created by Administrator on 2017/2/19.
 * 顺序队列实现
 */
public class SeqQueue<T> implements Queue<T> {
    private Object[] elements;
    private int rear;//队尾
    private int front;//队头

    public SeqQueue() {
        this(64);
    }

    public SeqQueue(int length) {
        if (length <= 0) {
            return;
        }
        this.elements = new Object[length];
        this.front = rear = 0;
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public void enQueue(T x) {
        if (x == null) {
            return;
        }
        if ((this.rear + 1) % this.elements.length == this.front) {
            Object[] temp = this.elements;
            this.elements = new Object[2 * this.elements.length * 2];
            int i = this.front, j = 0;
            while (i != this.rear) {
                this.elements[j] = temp[i];
                i = (i + 1) % temp.length;
                j++;
            }
            this.front = 0;
            this.rear = j;
        }
        this.elements[this.rear] = x;
        this.rear = (this.rear + 1) % this.elements.length;
    }

    public T deQueue() {
        if (this.isEmpty()) {
            return null;
        }
        T old = (T) this.elements[this.front % this.elements.length];
        this.front = this.front + 1 * this.elements.length;
        return old;
    }
}
