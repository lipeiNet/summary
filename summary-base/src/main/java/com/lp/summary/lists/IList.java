package com.lp.summary.lists;

/**
 * Created by Administrator on 2016/12/8.
 */
public interface IList<T> {
     boolean isEmpty();
     int length();
     T get(int i);
     void set(int i, T x);
     void append(T x);
     T remove(int i);
     void removeAll();
     T search(T key);
     void insert(int i,T x);
}
