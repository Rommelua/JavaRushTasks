package com.javarush.task.task07.task0702;

/* 
1. Программа должна создавать массив на 10 строк.
2. Программа должна считывать 8 строк для массива с клавиатуры.
3. Программа должна выводить на экран 10 строк, каждую с новой строки.
4. Программа должна выводить на экран массив (10 элементов) в обратном порядке.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] result = new String[10];
        for (int i = 0; i < 8; i++) {
            result[i] = reader.readLine();
        }
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.println(result[i]);
        }
    }
}