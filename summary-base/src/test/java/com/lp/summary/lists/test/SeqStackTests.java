package com.lp.summary.lists.test;

import com.lp.summary.lists.SStack;
import com.lp.summary.lists.impl.SeqStack;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/2/16.
 */
@RunWith(JUnit4.class)
public class SeqStackTests {
    @Test
    public void isEmpty(){
        SStack<String> stacks=new SeqStack<String>();
        Assert.assertTrue(stacks.isEmpty());
    }
    @Test
    public void push(){
        SStack<String> stacks=new SeqStack<String>();
        stacks.push("2");
        stacks.push("3");
        System.out.println(stacks.get());
    }
}
