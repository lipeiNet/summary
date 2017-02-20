package com.lp.summary.lists.test;

import com.lp.summary.lists.Node;
import com.lp.summary.lists.Queue;

/**
 * Created by Administrator on 2017/2/19.
 * 链表实现队列
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;

    public boolean isEmpty() {
        return this.front == this.rear && this.front == null;
    }

    public void enQueue(T x) {
        if (x == null) {
            return;
        }
        Node<T> p = new Node<T>(x, null);
        if (this.front == null) {
            this.front = p;
        } else {
            this.rear.next = p;
        }
        this.rear = p;
    }

    public T deQueue() {
        if (this.front == null) {
            return null;
        }
        T old = this.front.data;
        this.front = this.front.next;
        return old;
    }
}
