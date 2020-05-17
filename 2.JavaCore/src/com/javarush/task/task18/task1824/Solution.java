package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String name = reader.readLine();
                try (FileInputStream fis = new FileInputStream(name)) {
                } catch (FileNotFoundException e) {
                    System.out.println(name);
                    return;
                }
            }
        }
    }
}
