package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream def = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream temp = new PrintStream(outputStream);
        System.setOut(temp);
        testString.printSomething();
        System.setOut(def);
        String task = outputStream.toString();
        int result = 0;
        String[] arr = task.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        if (arr[1].equals("+")) {
            result = a + b;
        }
        if (arr[1].equals("-")) {
            result = a - b;
        }
        if (arr[1].equals("*")) {
            result = a * b;
        }
        System.out.println(task.trim() + " " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

