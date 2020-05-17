package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream def = System.out;
        ByteArrayOutputStream bar = new ByteArrayOutputStream();
        PrintStream temp = new PrintStream(bar);
        System.setOut(temp);

        testString.printSomething();
        System.setOut(def);
        String[] s = bar.toString().split("\\n");
        System.out.println(s[0]);
        for (int i = 1; i < s.length; i++) {
            if (i % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(s[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
