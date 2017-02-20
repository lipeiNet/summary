package com.lp.summary.lists.impl;

import com.lp.summary.lists.SStack;

/**
 * Created by Administrator on 2017/2/17.
 * 栈的应用
 */
public class StackApply {

    public static void main(String[] args) {
        boolean result=isValid("((1)");
        System.out.println(result);
    }

    /**
     * 验证程序中左右括号是否匹配
     */
    public static boolean isValid(String str) {
        SStack<Character> characterSStack = new SeqStack<Character>(str.length());
        boolean result=true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '{':
                    characterSStack.push(ch);
                    break;
                case '}':
                    boolean a = characterSStack.isEmpty();
                    boolean b = characterSStack.get() != '{';
                    if (a || b) {
                        result = false;
                    }
                    characterSStack.pop();
                    break;
            }
            if (!result) {
                break;
            }
        }
        if (!characterSStack.isEmpty()) {
            result=false;
          }
        return result;
    }
}
