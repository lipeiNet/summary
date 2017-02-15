package com.lp.summary.lists.impl;

import com.lp.summary.lists.Node;

/**
 * Created by Administrator on 2017/2/15.
 */
public class SortedSingleLinkedList<T extends Comparable<T>> extends SingleLinkedList<T> {

    public void insert(T x) {
        if (x == null) {
            return;
        }
        Node<T> prev = this.head;
        Node<T> p = prev.next;
        while (p != null && p.data.compareTo(x) < 0) {
            prev = p;
            p = p.next;
        }
        prev.next = new Node<T>(x, p);
    }
    public void insert(int i,T x){
        throw new UnsupportedOperationException("insert(int i,T x)");
    }
    public void append(T x) {
        throw new UnsupportedOperationException("append(T x)");
    }
    public void remove(T x){
        if (x==null){
            return;
        }
        Node<T> prev = this.head;
        Node<T> p = prev.next;
        while (p!=null&&p.data.compareTo(x)<0){
            prev=p;
            p=p.next;
        }
        if (p.data.compareTo(x)==0){
            prev.next=p.next;
        }
    }
}
