package com.lp.summary.lists.impl;

import com.lp.summary.lists.BinaryNode;
import com.lp.summary.lists.BinaryTTree;

/**
 * Created by Administrator on 2017/2/21.
 * 链表实现2叉树
 */
public class BinaryTree<T> implements BinaryTTree<T>{
    public BinaryNode<T> root;
    public BinaryTree() {
        this.root = null;
    }
    public BinaryTree(T[] prelist){
        this.root=create(prelist);
    }


    private int i=0;
    private BinaryNode<T> create(T[] prelist){
        BinaryNode<T> p=null;
        if (i<prelist.length){
            T elem=prelist[i];
            i++;
            if (elem!=null){
                p=new BinaryNode<T>(elem);
                p.left=create(prelist);
                p.right=create(prelist);
            }
        }
        return p;
    }
    public boolean isEmpty() {
        return this.root == null;
    }

    public int count() {
        return count(this.root);
    }
    private int count(BinaryNode<T> node){
        if (node==null){
            return 0;
        }
        return 1+count(node.left)+count(node.right);
    }

    public int height() {
        return height(this.root);
    }

    public int height(BinaryNode<T> root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return lh >= rh ? lh + 1 : rh + 1;
    }


    public void preOrder() {
        System.out.println("先根遍历开始：");
        preOrder(this.root);
        System.out.println();
    }
    public void preOrder(BinaryNode<T> p){
        if (p!=null){
            System.out.println(p.data.toString()+" ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }


    public void inOrder() {
        System.out.println("中根遍历开始：");
        inOrder(this.root);
        System.out.println();
    }

    public void inOrder(BinaryNode<T> p){
        if (p!=null){
            inOrder(p.left);
            System.out.println(p.data.toString()+" ");
            inOrder(p.right);
        }
    }

    public void postOrder() {
        System.out.println("后跟遍历");
        postOrder(this.root);
        System.out.println();
    }
    public void postOrder(BinaryNode<T> p){
        if (p!=null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.println(p.data.toString()+" ");
        }
    }

    public void levelOrder() {
        LinkedQueue<BinaryNode<T>> queue=new LinkedQueue<BinaryNode<T>>();
        BinaryNode<T> p=this.root;
        System.out.println("层次遍历:");
        while (p!=null){
            System.out.println(p.data+" ");
            if (p.left!=null){
               queue.enQueue(p.left);
            }
            if (p.right!=null){
                queue.enQueue(p.right);
            }
            queue.deQueue();
        }
        System.out.println();
    }

    public BinaryNode<T> search(T key) {
        return search(this.root, key);
    }

    public BinaryNode<T> search(BinaryNode<T> node,T key) {
        if (node == null || key == null) {
            return null;
        }
        if (node.data.equals(key)) {
            return node;
        }
        BinaryNode<T> find = search(node.left, key);
        if (find == null) {
            find = search(node.right, key);
        }
        return find;
    }

    public BinaryNode<T> getParent(BinaryNode<T> node) {
       if (this.root==null||node==null||this.root==node){
           return null;
       }
        return getParent(this.root,node);
    }
    //以p为根的子树中查找，并返回node节点的父母节点
    public BinaryNode<T> getParent(BinaryNode<T> p,BinaryNode<T> node){
        if (p.left==node||p.right==node){
            return p;
        }
        BinaryNode<T> find=getParent(p.left,node);
        if (find==null){
            find=getParent(p.right,node);
        }
        return find;
    }

    public void insertRoot(T x) {
        this.root = new BinaryNode<T>(x, this.root, null);
    }


    public BinaryNode<T> insertChild(BinaryNode<T> p, T x, boolean leftChild) {
        if (p==null||x==null){
            return null;
        }
        if (leftChild){
            p.left=new BinaryNode<T>(x,p.left,null);
            return p.left;
        }
        p.right=new BinaryNode<T>(x,null,p.right);
        return p.right;
    }

    public void removeChild(BinaryNode<T> p, boolean leftChild) {
        if (p != null) {
            if (leftChild) {
                p.left = null;
            } else {
                p.right = null;
            }
        }
    }

    public void removeAll() {
        this.root=null;
    }
}
