package com.lp.summary.lists.impl;

import com.lp.summary.lists.DLinkedNode;
import com.lp.summary.lists.Node;
import com.lp.summary.lists.Queue;

/**
 * Created by Administrator on 2017/2/15.
 * 排序双链表
 */
public class SortedDLinkedList<T extends Comparable<T>> extends CirDLinkedList<T> {

    public void insert(T x) {
        if (x == null) {
            return;
        }
        DLinkedNode<T> p = this.head.next;
        while (p != this.head && p.data.compareTo(x) < 0) {
            p = p.next;
        }
        DLinkedNode<T> q = new DLinkedNode<T>(x, p.prev, p);
        p.prev.next = q;
        p.prev = q;
    }

    public void remove(T x) {
        if (x == null) {
            return;
        }
        DLinkedNode<T> p = this.head.next;
        while (p != this.head && p.data.compareTo(x) < 0) {
            p = p.next;
        }
        if (p != this.head && p.data.compareTo(x) == 0) {
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
    }


}
