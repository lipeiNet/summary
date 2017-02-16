package com.lp.summary.others;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/2/15.
 */
public class DuGui {
    public static void main(String[] args) {
        System.out.println(test2(1024L));
    }

    public static int test(Long  n){
        if(n == null ){
            return 0;
        }
        if(n.equals(1)) {
            return 1;
        }else{
            Long temp1 = n % 2;
            Long temp2 = n / 2;
            if(temp1==0&&temp2==1){
                //表示最后一次计算的结果是2
                return 1;
            }
            if(temp1==0){
                return 0|test(n/2);
            }else{
                return 0;
            }
        }
    }

    public static boolean test2(Long n ){
        if(test(n)==1){
            return true;
        }else{
            return false;
        }
    }
}
