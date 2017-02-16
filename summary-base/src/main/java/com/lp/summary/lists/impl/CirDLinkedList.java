package com.lp.summary.lists.impl;

import com.lp.summary.lists.DLinkedNode;
import com.lp.summary.lists.IList;

/**
 * Created by Administrator on 2017/2/15.
 * 循环双链表实现
 */
public class CirDLinkedList<T> implements IList<T> {

    public DLinkedNode<T> head;
    public CirDLinkedList(){
        head=new DLinkedNode<T>();
        head.prev=head;
        head.next=head;
    }
    public boolean isEmpty() {
        return this.head.next == head;
    }

    public int length() {
        DLinkedNode<T> p = this.head;
        int i = 0;
        while (p.next != head) {
            p = p.next;
            i++;
        }
        return i;
    }

    public T get(int i) {
        if (i < 0) {
            return null;
        }
        DLinkedNode<T> p = this.head.next;
        int j = 0;
        while (p != head) {
            if (i == j) {
                T old = p.data;
                return old;
            }
            p = p.next;
            j++;
        }
        return null;
    }

    public void set(int i, T x) {
        if (i < 0 || x == null) {
            return;
        }
        DLinkedNode<T> p = this.head.next;
        int j = 0;
        while (p != head) {
            if (j == i) {
                p.data = x;
            }
            j++;
            p = p.next;
        }
    }

    public void append(T x) {
        insert(Integer.MAX_VALUE, x);
    }

    public T remove(int i) {
        if (i < 0) {
            return null;
        }
        DLinkedNode<T> p = this.head;
        for (int j = 0; p.next != this.head && j <= i; j++) {
            p = p.next;
        }
        if (p != this.head) {
            T old = p.data;
            p.prev.next = p.next;
            p.next.prev = p.prev;
            return old;
        }
        return null;
    }

    public void removeAll() {
        this.head.next=head;
    }

    public T search(T key) {
        return null;
    }

    public void insert(int i, T x) {
        if (i < 0 || x == null) {
            return;
        }
        DLinkedNode<T> p = this.head;
        for (int j = 0; p.next != this.head && j < i; j++) {//找到要添加节点的位置
            p = p.next;
        }
        DLinkedNode<T> q = new DLinkedNode<T>(x, p, p.next);
        p.next.prev = q;
        p.next = q;
    }

    public void insert(T x) {
       throw new UnsupportedOperationException("insert(T x)");
    }

    public void remove(T x) {
        throw new UnsupportedOperationException("remove(T x)");
    }
}

