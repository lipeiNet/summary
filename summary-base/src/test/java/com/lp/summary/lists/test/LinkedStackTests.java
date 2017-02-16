package com.lp.summary.lists.test;

import com.lp.summary.lists.SStack;
import com.lp.summary.lists.impl.LinkedStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/2/16.
 */
@RunWith(JUnit4.class)
public class LinkedStackTests {
    @Test
    public void linkedStask() {
        String[] strs = {"1", "2", "3"};
        SStack<String> stacks = new LinkedStack<String>(strs);
        System.out.println(stacks.get());
    }
    @Test
    public void push(){
        SStack<String> stacks = new LinkedStack<String>();
        stacks.push("1");
        stacks.push("2");
        stacks.push("3");
        System.out.println(stacks.pop());
        System.out.println(stacks.get());
    }
}
