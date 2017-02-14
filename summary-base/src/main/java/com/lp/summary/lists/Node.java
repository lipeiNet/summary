package com.lp.summary.lists;

/**
 * Created by Administrator on 2017/2/14.
 * 定义节点
 */
public class Node<T> {
    public T data;//数据域
    public Node next;//地址域

    public Node() {
        this(null, null);
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
}
