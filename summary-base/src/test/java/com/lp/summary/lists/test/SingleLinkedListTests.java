package com.lp.summary.lists.test;

import com.lp.summary.lists.IList;
import com.lp.summary.lists.impl.SingleLinkedList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2017/2/14.
 */
@RunWith(JUnit4.class)
public class SingleLinkedListTests {
    @Test
    public void length() {
        String[] elements = {"1", "2", "3"};
        IList<String> list = new SingleLinkedList<String>(elements);
        assertEquals(3,list.length());
    }
    @Test
    public void get(){
        String[] elements = {"1", "2", "3"};
        IList<String> list = new SingleLinkedList<String>(elements);
        assertEquals("1",list.get(0));
    }
    @Test
    public void insert(){
        String[] elements = {"1", "2", "3"};
        IList<String> list = new SingleLinkedList<String>(elements);
        list.insert(2,"4");
        assertEquals("4",list.get(2));
    }
    @Test
    public void  remove(){
        String[] elements = {"1", "2", "3"};
        IList<String> list = new SingleLinkedList<String>(elements);
        list.remove(1);
        assertEquals("3",list.get(1));
        assertEquals(2,list.length());
    }
}
