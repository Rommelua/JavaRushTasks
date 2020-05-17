package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream def = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream temp = new PrintStream(outputStream);
        System.setOut(temp);
        testString.printSomething();
        String text = outputStream.toString();
        System.setOut(def);
        System.out.println(text);
        String path = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                path = reader.readLine();
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            writer.write(text);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

