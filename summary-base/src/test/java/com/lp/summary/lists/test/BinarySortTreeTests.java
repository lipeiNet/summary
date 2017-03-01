package com.lp.summary.lists.test;

import com.lp.summary.lists.BinaryTTree;
import com.lp.summary.lists.impl.BinarySortTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/3/1.
 */
@RunWith(JUnit4.class)
public class BinarySortTreeTests {
    @Test
    public void insert(){
        Integer[] integers={10,7,15,5,9,3,6,13,20};
        BinarySortTree binaryTTree=new BinarySortTree(integers);
        binaryTTree.remove(7);

    }
}
