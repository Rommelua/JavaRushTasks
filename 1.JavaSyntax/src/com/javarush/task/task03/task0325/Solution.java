package com.javarush.task.task03.task0325;

/* 
Финансовые ожидания
Вывести на экран надпись "Я буду зарабатывать $n в час".
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());//напишите тут ваш код
        System.out.printf("Я буду зарабатывать $%d в час",n);
    }
}
