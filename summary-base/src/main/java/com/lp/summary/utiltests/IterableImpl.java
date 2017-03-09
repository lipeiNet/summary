package com.lp.summary.utiltests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/3/6.
 */
public class IterableImpl implements Iterable {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(5);
        list.add(6);
        list.add(1);
        System.out.println(list.get(1));
        int j=10;
       j= j+(j>>1);
        System.out.println(j);
    }
    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                return null;
            }

            public void remove() {

            }
        };
    }
}
