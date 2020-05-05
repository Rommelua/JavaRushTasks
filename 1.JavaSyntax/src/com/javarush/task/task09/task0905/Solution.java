package com.javarush.task.task09.task0905;

/* 
1. Метод getStackTraceDepth должен возвращать глубину своего стек-трейса.
2. Метод getStackTraceDepth должен выводить на экран глубину своего стек-трейса.
3. Воспользуйся методом Thread.currentThread().getStackTrace().
4. Метод main должен вызывать метод getStackTraceDepth.
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDepth();
    }

    public static int getStackTraceDepth() {
        System.out.println(Thread.currentThread().getStackTrace().length);

        return Thread.currentThread().getStackTrace().length;
    }
}

