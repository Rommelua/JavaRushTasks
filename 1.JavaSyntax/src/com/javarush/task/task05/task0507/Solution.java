package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        int sum = 0;
        while (true) {
            int number = Integer.parseInt(reader.readLine());
            if (number == -1)
            break;
            counter++;
            sum += number;

        }
        System.out.println((double) sum/counter);
    }
}

