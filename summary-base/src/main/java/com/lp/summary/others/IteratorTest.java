package com.lp.summary.others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> lists=new ArrayList<String>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.add("5");
        Iterator i=lists.iterator();
        while (i.hasNext()){
            String str=i.next().toString();
            if (str=="2"){
                i.remove();
            }
        }
        for (String s:lists) {
            System.out.println(s+",");
        }
    }
}
