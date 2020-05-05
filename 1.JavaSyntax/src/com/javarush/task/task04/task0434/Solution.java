package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int a=0;
        int b = 0;
        while (a++ < 10) {
            while (b++ < 10)
                System.out.print(a*b + " ");
            System.out.println();
            b = 0;
        }

    }
}
