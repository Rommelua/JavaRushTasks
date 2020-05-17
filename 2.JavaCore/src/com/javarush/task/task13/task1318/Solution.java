package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(path);
        StringBuilder sb = new StringBuilder();
        while (inputStream.available() > 0) {
            sb.append((char)inputStream.read());
        }
        inputStream.close();
        System.out.println(sb.toString());
    }
}