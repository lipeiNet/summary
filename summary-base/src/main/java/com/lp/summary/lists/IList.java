package com.lp.summary.lists;

/**
 * Created by Administrator on 2017/2/13.
 * 线性表数据抽象类型
 */
public interface IList<T> {
    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 表的长度
     * @return
     */
    int length();

    /**
     * 根据索引获取长度
     * @param i
     * @return
     */
    T get(int i);

    /**
     * 设置第i个元素值为x
     * @param i
     * @param x
     */
    void set(int i,T x);

    /**
     * 在线性表最后插入x元素
     * @param x
     */
    void append(T x);

    /**
     * 异常第i个元素并返回值
     * @param i
     * @return
     */
    T remove(int i);

    /**
     * 删除线性表中所有元素
     */
    void removeAll();

    /**
     * 查询首次出现关键字为key的元素
     * @param key
     * @return
     */
    T search(T key);

    void insert(int i,T x);
}
