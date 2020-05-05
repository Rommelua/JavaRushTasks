package com.javarush.task.task04.task0425;

/* 
Цель установлена!
для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if (a>0 && b>0)
            System.out.println(1);
        if (a<0 && b>0)
            System.out.println(2);
        if (a<0 && b<0)
            System.out.println(3);
        if (a>0 && b<0)
            System.out.println(4);

    }
}
