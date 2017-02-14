package com.lp.summary.lists.impl;

import com.lp.summary.lists.IList;
import com.lp.summary.lists.Node;

/**
 * Created by Administrator on 2017/2/14.
 * 单链表的实现
 */
public class SingleLinkedList<T> implements IList<T> {
    private Node<T> head;//头指针

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
        int j = 0;
        Node<T> p = this.head.next;
        while (p != null) {
            if (j == i) {
                return p.data;
            }
            p = p.next;
            j++;
        }
        return null;
    }

    public void set(int i, T x) {
        int j = 0;
        Node<T> p = this.head.next;
        while (p != null) {
            if (j == i) {
                p.data = x;
            }
            p = p.next;
            j++;
        }
    }

    public void append(T x) {
        insert(Integer.MAX_VALUE, x);
    }

    public T remove(int i) {
        int j = 0;
        Node<T> p = this.head.next;
        T result = null;
        while (p != null) {
            if (j == i) {
                result = (T) p.next.data;
                p.next = p.next.next;
            }
            p = p.next;
            j++;
        }
        return result;
    }

    public void removeAll() {
        this.head.next=null;
    }

    public T search(T key) {
        return null;
    }

    public void insert(int i, T x) {
        int j = 0;
        Node<T> p = this.head.next;
        while (p != null) {
            if (j == i) {
                p.next = new Node<T>(x, p.next);
            }
            p = p.next;
            j++;
        }
    }
}
