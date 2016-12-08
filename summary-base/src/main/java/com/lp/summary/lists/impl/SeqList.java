package com.lp.summary.lists.impl;

import com.lp.summary.lists.IList;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/3.
 * 顺序表类
 */
public class SeqList<T> implements IList<T> {

    private Object[] elements;//对象数组，私有成员
    private int len;//顺序表长度

    public SeqList() {
        this(64);
    }

    public SeqList(int size) {
        this.elements = new Object[size];
        this.len = 0;
    }

    public boolean isEmpty() {
        return this.len == 0;
    }

    public int length() {
        return this.len;
    }

    public T get(int i) {
        if (i >= 0 && i < this.len) {
            return (T) this.elements[i];
        }
        return null;
    }

    public void set(int i, T x) {
        if (x == null) {
            return;
        }
        if (i >= 0 && i < this.len) {
            this.elements[i] = x;
        }
        throw new IndexOutOfBoundsException(i + "");
    }

    public void append(T x) {
        insert(this.len,x);

    }

    public T remove(int i) {
        return null;
    }

    public void removeAll() {


    }

    public T search(T key) {
        return null;
    }

    public void insert(int i,T x){
        if (x==null){
            return;
        }
        //如果线性表满了就进行扩容
        if (this.len==elements.length){
           Object[] temp=this.elements;
            this.elements=new Object[this.len*2];
            for (int j=0;j<temp.length;j++){
                this.elements[j]=temp[j];
            }
            if (i<0){
                i=0;
            }
            if (i>this.len){
                i=this.len;
            }
            for (int j=this.len-1;j>=i;j--){
                this.elements[j+1]=this.elements[j];
            }
            this.elements[i]=x;
            this.len++;
        }
    }
    @Override
    public String toString() {
        String str = "(";
        if (this.len > 0) {
            str += this.elements[0].toString();
        }
        for (int i = 1; i < this.len; i++) {
            str += "," + this.elements[i].toString();
        }
        return str + ")";
    }
}
