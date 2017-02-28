package com.lp.summary.lists.impl;

import com.lp.summary.lists.BinaryNode;

/**
 * Created by Administrator on 2017/2/22.
 * 二叉排序树
 */
public class BinarySortTree <T extends Comparable<T>> extends BinaryTree<T> {
    public BinarySortTree(){
        super();
    }
    public BinarySortTree(T[] values){
        super();
        for (int i=0;i<values.length;i++){
        }
    }
    public void insert(T x) {
        if (x == null) {
            return;
        }
        if (this.root == null) {
            this.root = new BinaryNode<T>(x);
        } else {
            BinaryNode<T> p = this.root, parent = null;
            while (p != null) {
                parent = p;
                if (x.compareTo(p.data) == 0) {
                    return;
                }
                if (x.compareTo(p.data) < 0) {
                    p = p.left;
                }
                if (x.compareTo(p.data) > 0) {
                    p = p.right;
                }
            }
            p = new BinaryNode<T>(x);
            if (x.compareTo(parent.data) <= 0) {
                parent.left = p;
            } else {
                parent.right = p;
            }
        }
    }
    public BinaryNode<T> remove(T x){
        if (this.root==null||x==null){
            return null;
        }
        return remove(x,root,null);
    }
    //在以p为根的子树中删除元素为x的节点，parent是p的父母节点，返回删除节点，递归算法
    private BinaryNode<T> remove(T x,BinaryNode<T> p,BinaryNode<T> parent){
        if (p==null){
            return null;
        }
        if (x.compareTo(p.data)<0){
            return remove(x,p.left,p);
        }
        if (x.compareTo(p.data)>0){
            return remove(x,p.right,p);
        }
        if (p.left!=null&&p.right!=null){
            BinaryNode<T> insucc=p.right;
            while (insucc.left!=null){
                insucc=insucc.left;
            }
            p.data=insucc.data;
            return remove(p.data,p.right,p);
        }
        if (parent==null){
            if (p.left!=null){
                root=p.left;
            }else {
                root=p.right;
            }
        }
        if (p==parent.left){
            if (p.left!=null){
                parent.left=p.left;
            }else {
                parent.left=p.right;
            }
        }else {
            if (p.left!=null){
                parent.right=p.left;
            }else {
                parent.right=p.right;
            }
        }
        return p;
    }
}
