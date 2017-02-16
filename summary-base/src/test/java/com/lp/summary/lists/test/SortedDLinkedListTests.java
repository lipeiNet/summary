package com.lp.summary.lists.test;

import com.lp.summary.lists.IList;
import com.lp.summary.lists.impl.SortedDLinkedList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/2/15.
 */
@RunWith(JUnit4.class)
public class SortedDLinkedListTests {
    @Test
    public void insert(){
        IList<Integer> list=new SortedDLinkedList<Integer>();
        list.insert(1);
        list.insert(10);
        list.insert(1);
        list.insert(5);
        list.insert(2);
        list.insert(3);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
    }
}
