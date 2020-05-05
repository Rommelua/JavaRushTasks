package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
Вывести на экран текст:
"Меня зовут name.
Я родился d.m.y"


*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        System.out.printf("Меня зовут %s.\n",s);
        System.out.printf("Я родился %d.%d.%d", c,b,a);
    }
}
