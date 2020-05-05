package com.javarush.task.task09.task0906;

/* 
Пример вывода:
com.javarush.task.task09.task0906.Solution: main: In main method

*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement[] stArr = Thread.currentThread().getStackTrace();
        System.out.println(stArr[2].getClassName() + ": " + stArr[2].getMethodName() + ": " + s);
    }
}
