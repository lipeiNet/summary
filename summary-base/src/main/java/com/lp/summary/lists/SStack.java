package com.lp.summary.lists;

/**
 * Created by Administrator on 2017/2/16.
 * 栈的接口
 */
public interface SStack<T> {
    /**
     * 验证是否是空栈
     * @return
     */
    boolean isEmpty();

    /**
     * 进栈
     * @param x
     */
    void push(T x);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 取栈顶元素
     * @return
     */
    T get();
}
