package com.lp.summary.others;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2017/2/23.
 */
public class AC {
    public static void main(String[] args) {
        System.out.println(3*0.1f);
        System.out.println(3 * 0.1f == 0.3);
        Collection collection=new AbstractCollection() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

    }
}
