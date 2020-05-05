package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ar = new int[5];
        for (int i = 0; i < 5; i++) {
            ar[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.stream(ar).sorted().forEach(System.out::println);
    }
}
