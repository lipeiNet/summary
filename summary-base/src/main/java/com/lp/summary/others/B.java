package com.lp.summary.others;

/**
 * Created by Administrator on 2016/12/21.
 */
public class B {
    public void test(B b){};

    public static void main(String[] args) {
      /*  String aa="hello,world,";
        if (aa.charAt(aa.length()-1)==','){
            aa=aa.substring(0,aa.length()-1);
            System.out.println(aa);
        }*/
        Integer a=3;
        Integer b=10;
        double aa=Double.parseDouble(a.toString());
        double bb=Double.parseDouble(b.toString());
        double c= aa/bb;
        System.out.println(c);
    }
}
