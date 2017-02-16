package com.lp.summary.lists.test;

import com.lp.summary.lists.IList;
import com.lp.summary.lists.impl.CirDLinkedList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/2/15.
 */
@RunWith(JUnit4.class)
public class CirDLinkedListTests {
    @Test
    public void lenght(){
        IList<String> list=new CirDLinkedList<String>();
        list.append("1");
        list.append("2");
        list.append("3");
        Assert.assertEquals(0,list.length());
    }
    @Test
    public void isEmpty(){
        IList<String> list=new CirDLinkedList<String>();
        Assert.assertTrue(list.isEmpty());
    }
    @Test
    public void insert(){
        IList<String> list=new CirDLinkedList<String>();
        list.append("1");
        list.append("2");
        list.append("3");
        list.insert(0,"4");
        Assert.assertEquals("4",list.get(0));
    }
    @Test
    public void set(){
        IList<String> list=new CirDLinkedList<String>();
        list.append("1");
        list.append("2");
        list.append("3");
        list.set(2,"5");
        Assert.assertEquals("5",list.get(2));
    }
    @Test
    public void remove(){
        IList<String> list=new CirDLinkedList<String>();
        list.append("1");
        list.append("2");
        list.append("3");
        list.remove(0);
        Assert.assertEquals("2",list.get(0));
    }
    @Test
    public void length(){
        IList<String> list=new CirDLinkedList<String>();
        list.append("1");
        System.out.println(list.length());
    }
}
