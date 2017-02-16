package com.lp.summary.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(2);
        System.out.println(a.get(2));
        Integer[] arrs={1,3,2};
        System.out.println(arrs[1]);
    }
}
