package com.lp.summary.others;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Administrator on 2017/2/22.
 */
@RunWith(JUnit4.class)
public class StringTests {
    @Test
    public void indexOf1(){
        String str="helloworld";
        for (char c:str.toCharArray()){
            System.out.println(c+",");
        }

        int a=str.indexOf(104,0);
        System.out.println(a);
        System.out.println(charToByteAscii('h'));
    }
    public static byte charToByteAscii(char ch){
        byte byteAscii = (byte)ch;
        return byteAscii;
    }
}
