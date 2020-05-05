package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int sum = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int number = Integer.parseInt(reader.readLine());
            sum += number;
            if (number == -1)
            break;
        }
        System.out.println(sum);
    }
}
