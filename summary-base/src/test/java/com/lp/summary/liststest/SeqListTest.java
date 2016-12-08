package com.lp.summary.liststest;

import com.lp.summary.lists.SeqList;
import org.junit.Test;

/**
 * Created by Administrator on 2016/12/5.
 */
public class SeqListTest {
    @Test
    public void test1(){
        SeqList list=new SeqList();
        list.insert(1,"hello");
        list.insert(2,"1234");
        for (int i=0;i<list.length();i++){
            System.out.println(list.get(i));
        }
    }
}
