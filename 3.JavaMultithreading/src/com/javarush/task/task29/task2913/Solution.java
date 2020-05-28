package com.javarush.task.task29.task2913;

import java.util.Random;
import java.util.stream.IntStream;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
//        StringBuilder sb = new StringBuilder();
//        IntStream.rangeClosed(a, b).forEach(i -> sb.append(i).append(" "));
//        IntStream.rangeClosed(b, a).forEach(i -> sb.append(i).append(" "));
//        return a < b ? sb.toString().trim() : sb.reverse().toString().trim();
        StringBuilder result = new StringBuilder(String.valueOf(a));
        while(a != b) {
            result = a > b ? result.append(" " + --a) : result.append(" " + ++a);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));

    }
}