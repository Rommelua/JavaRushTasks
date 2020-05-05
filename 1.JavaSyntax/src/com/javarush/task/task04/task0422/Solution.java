package com.javarush.task.task04.task0422;

/* 
18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись "Подрасти еще".

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        int a = Integer.parseInt(reader.readLine());
        if (a<18)
            System.out.println("Подрасти еще");
    }
}
