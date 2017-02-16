package com.lp.summary.lists.impl;

import com.lp.summary.lists.Node;
import com.lp.summary.lists.SStack;

/**
 * Created by Administrator on 2017/2/16.
 * 栈的链表实现
 */
public class LinkedStack<T> implements SStack<T> {
    public Node<T> top;
    public LinkedStack(){
        top=new Node<T>(null,null);
    }
    public LinkedStack(T[] elements) {
        if (elements == null) {
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            this.top = new Node<T>(elements[i], this.top);
        }
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(T x) {
        if (x==null){
            return;
        }
        this.top=new Node<T>(x,this.top);
    }

    public T pop() {
        if (this.top != null) {
            T old = this.top.data;
            this.top = this.top.next;
            return old;
        }
        return null;
    }

    public T get() {
        return this.top == null ? null : this.top.data;
    }
}
