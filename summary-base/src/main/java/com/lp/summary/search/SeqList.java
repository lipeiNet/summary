package com.lp.summary.search;

/**
 * Created by Administrator on 2017/2/13.
 * 线性表类
 */
public class SeqList implements com.lp.summary.lists.IList {
    private Object[] element;
    private int len;
    //设置默认长度为64
    public SeqList(){
        this(64);
    };
    public SeqList(int size) {
        this.element = new Object[size];
        this.len = 0;
    }
    public boolean isEmpty() {
        return this.len == 0 ? false : true;
    }

    public int length() {
        return this.len;
    }

    public Object get(int i) {
        if (i >= 0 & i < this.len) {
            return this.element[i];
        }
        return null;
    }

    public void set(int i, Object x) {
        if (x==null){
            return;
        }
        if (i>=0&&i<this.len){
            this.element[i]=x;
        }
    }

    public void insert(int i,Object x){
        if (x==null){
            return;
        }
        if (this.len==this.element.length){
            Object[] temp=this.element;
            this.element=new Object[this.element.length*2];
            for (int m=0;m<temp.length-1;m++){
                this.element[m]=temp[m];
            }
        }
        if (i<0){
            i=0;
        }
        if (i>this.len-1){
            i=this.len;
        }
        for (int j=i;j<=this.len-2;j++){
            this.element[j++]=this.element[j];
        }
        this.element[this.len]=this.element[this.len-1];
        this.element[i]=x;
        this.len++;
    }
    public void append(Object x) {
        if (x==null){
            return;
        }
        this.element[this.len-1]=x;
    }

    public Object remove(int i) {

        return null;
    }

    public void removeAll() {

    }

    public Object search(Object key) {
        return null;
    }
}
