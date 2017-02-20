package com.lp.summary.lists.test;

import com.lp.summary.lists.Queue;
import com.lp.summary.lists.impl.SeqQueue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/2/19.
 */
@RunWith(JUnit4.class)
public class SeqQueueTests {
    @Test
    public void isEmpty() {
        Queue<String> queue = new SeqQueue<String>(64);
        Assert.assertTrue(queue.isEmpty());
    }
    @Test
    public void enQueue(){
        Queue<String> queue = new SeqQueue<String>(4);
        queue.enQueue("1");
        queue.enQueue("2");
        queue.enQueue("3");
        queue.enQueue("4");
        queue.enQueue("5");
        System.out.println(queue.deQueue());
    }
}
