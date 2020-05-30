package com.javarush.task.task30.task3004;

import java.util.concurrent.ForkJoinPool;

/* 
Fork/Join
*/
public class Solution {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        String result1 = solution.binaryRepresentationMethod(Integer.MAX_VALUE);
        long finish = System.currentTimeMillis();
        System.out.println(result1);
        System.out.println(finish - start + "ms");

        System.out.println();
        start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(Integer.MAX_VALUE));
        finish = System.currentTimeMillis();
        System.out.println(result2);
        System.out.println(finish - start + "ms");

    }

}
