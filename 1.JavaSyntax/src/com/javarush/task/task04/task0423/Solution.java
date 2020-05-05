package com.javarush.task.task04.task0423;

/* 
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись "И 18-ти достаточно".


*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        int a = Integer.parseInt(reader.readLine());
        if (a>20)
            System.out.println("И 18-ти достаточно");

    }
}
