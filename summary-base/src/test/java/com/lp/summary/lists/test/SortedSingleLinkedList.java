package com.lp.summary.lists.test;

import com.lp.summary.lists.IList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/2/15.
 */
@RunWith(JUnit4.class)
public class SortedSingleLinkedList {
    @Test
    public void insert(){
        IList<Integer> list=new com.lp.summary.lists.impl.SortedSingleLinkedList<Integer>();
        list.insert(1);
        list.insert(3);
        list.insert(2);
        System.out.println();
    }
}
