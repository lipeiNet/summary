package com.lp.summary.lists.test;

import com.lp.summary.lists.IList;
import com.lp.summary.lists.impl.SeqList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2017/2/14.
 */
@RunWith(JUnit4.class)
public class SeqListTests {
    @Test
    public void isEmpty() {
        IList<String> list = new SeqList<String>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void length() {
        IList<String> list = new SeqList<String>();
        list.append("1");
        assertEquals(1, list.length());
    }
    @Test
    public void insert(){
        IList<String> list = new SeqList<String>();
        list.append("1");
        list.append("2");
        list.insert(1,"3");
        assertEquals("3",list.get(1));
    }
    @Test
    public void remove(){
        IList<String> list = new SeqList<String>();
        list.append("1");
        list.append("2");
        list.remove(0);
        assertEquals("2",list.get(0));
    }
}
