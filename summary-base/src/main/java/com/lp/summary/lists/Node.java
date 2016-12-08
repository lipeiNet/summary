package com.lp.summary.lists;

/**
 * Created by Administrator on 2016/12/5.
 */
public class Node<T> {
    public T data;
    public Node<T> next;
    public Node(){};
    public Node(T data,Node<T> next){
        this.data=data;
        this.next=next;
    }
}
