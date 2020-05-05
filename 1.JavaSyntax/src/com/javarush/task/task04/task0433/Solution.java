package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        int a=10;
        int b = 10;
        while (a-- > 0) {
            while (b-- > 0)
                System.out.print("S");
            System.out.println();
            b = 10;
        }

    }
}
