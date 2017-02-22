package com.lp.summary.lists;

/**
 * Created by Administrator on 2017/2/21.
 * 二叉树节点
 */
public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {//构建叶子节点
        this(data, null, null);
    }

    public BinaryNode() {
        this(null, null, null);
    }
}
