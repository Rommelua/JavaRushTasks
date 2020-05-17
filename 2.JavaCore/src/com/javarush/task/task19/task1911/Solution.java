package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
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
        System.out.println(outputStream.toString().toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
