package com.lp.summary.lists.impl;

import com.lp.summary.lists.IList;
import com.lp.summary.lists.Node;

/**
 * Created by Administrator on 2017/2/14.
 * 单链表的实现
 */
public class SingleLinkedList<T> implements IList<T> {
    protected Node<T> head;//头指针

    public SingleLinkedList() {
        this.head = new Node<T>();
    }

    public SingleLinkedList(T[] elements) {
        this();
        Node<T> rear = this.head;
        for (int i = 0; i < elements.length; i++) {
            rear.next = new Node<T>(elements[i], null);
            rear = rear.next;//类似i++（记录当前的节点）
        }
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public int length() {
        int i = 0;
        Node<T> p = this.head.next;
        while (p != null) {
            p = p.next;
            i++;
        }
        return i;
    }

    public T get(int i) {
        if (i >= 0) {
            Node<T> p = this.head;
            for (int j = 0; j <= i; j++) {
                p = p.next;
            }
            return p.data;
        }
        return null;
    }

    public void set(int i, T x) {
        if (i >= 0) {
            Node<T> p = this.head;
            for (int j = 0; j <= i; j++) {
                p = p.next;
            }
            p.data = x;
        }
    }

    public void append(T x) {
        insert(Integer.MAX_VALUE, x);
    }

    public T remove(int i) {
        if (i >= 0) {
            Node<T> p = this.head;
            for (int j = 0; p.next != null && j < i; j++) {
                p = p.next;
            }
            T old = p.data;
            p.next = p.next.next;
            return old;
        }
        return null;
    }

    public void removeAll() {
        this.head.next = null;
    }

    public T search(T key) {
        return null;
    }

    public void insert(int i, T x) {
        if (i >= 0) {
            Node<T> p = this.head;
            for (int j = 0; p.next != null && j < i; j++) {
                p = p.next;
            }
            p.next = new Node<T>(x, p.next);
        }
    }

    public void insert(T x) {
        throw new UnsupportedOperationException("insert(T x)");
    }

    public void remove(T x) {
        throw new UnsupportedOperationException("remove(T x)");
    }
}
