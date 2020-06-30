package com.javarush.task.task39.task3908;

import java.util.Arrays;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("abcaacb"));
    }

    public static boolean isPalindromePermutation(String s) {
        int[] quantity = new int[256];
        s.toLowerCase().chars().forEach(ch -> quantity[ch]++);
        int odd = (int) Arrays.stream(quantity).filter(q -> q % 2 == 1).count();
        return odd < 2;
    }
}
