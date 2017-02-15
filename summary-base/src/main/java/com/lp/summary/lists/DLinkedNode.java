package com.lp.summary.lists;

/**
 * Created by Administrator on 2017/2/15.
 * 双链表节点
 */
public class DLinkedNode<T> {
    public T data;//数据域
    public DLinkedNode<T> prev;//前驱节点
    public DLinkedNode<T> next;//后继节点

    public DLinkedNode() {
        this(null, null, null);
    }

    public DLinkedNode(T data, DLinkedNode<T> prev, DLinkedNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
