package com.lp.summary.others;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/12/6.
 */
public class StringFormat {
    @Test
    public void test1(){
        String str = String.format("%04d", 1);
        System.out.println(str);
    }
    @Test
    public void test2(){
        int orderNo=0;
        try{
            Random random = new Random();
            String length="1";
            for(int x=1;x<5;x++){
                length+="0";
            }
            int i = Integer.parseInt(length);
            orderNo = random.nextInt(i - 1) + i;
        }catch (Exception e){
        }
    }
    @Test
    public void test3(){
        long start = System.currentTimeMillis();
        AtomicIntegerCompareTest test = new AtomicIntegerCompareTest(0);
        for( int i=0;i< 100000;i++){
            test.increase();
        }
        long end = System.currentTimeMillis();
        System.out.println("time elapse:"+(end -start));
        long start1 = System.currentTimeMillis();
        AtomicInteger atomic = new AtomicInteger(0);
        for( int i=0;i< 100000;i++){
            atomic.incrementAndGet();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("time elapse:"+(end1 -start1) );
    }

}
