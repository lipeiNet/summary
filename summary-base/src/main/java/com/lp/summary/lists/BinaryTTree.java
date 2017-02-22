package com.lp.summary.lists;

/**
 * Created by Administrator on 2017/2/21.
 * 2叉树节点接口
 */
public interface BinaryTTree<T> {
    /**
     * 判断二叉树是否为null
     * @return
     */
    boolean isEmpty();

    /**
     * 返回二叉树节点个数
     * @return
     */
    int count();

    /**
     * 返回二叉树的高度
     * @return
     */
    int height();

    /**
     * 先根遍历
     */
    void preOrder();

    /**
     * 中根遍历
     */
    void inOrder();

    /**
     * 后跟遍历
     */
    void postOrder();

    /**
     * 层次遍历
     */
    void levelOrder();

    /**
     * 查找并返回首次出现关键字为key的元素节点
     * @param key
     * @return
     */
    BinaryNode<T> search(T key);

    /**
     * 返回弄得节点的父节点
     * @param node
     * @return
     */
    BinaryNode<T> getParent(BinaryNode<T> node);

    /**
     * 插入x作为根节点
     * @param x
     */
    void insertRoot(T x);

    /**
     * 插入p的孩子节点（leftchild验证为左子树还是右子树）
     * @return
     */
    BinaryNode<T> insertChild(BinaryNode<T> p,T x,boolean leftChild);

    /**
     * 删除p节点的左或者右子树
     * @param p
     * @param leftChild
     */
    void removeChild(BinaryNode<T> p,boolean leftChild);

    /**
     * 删除二叉树
     */
    void removeAll();
}
