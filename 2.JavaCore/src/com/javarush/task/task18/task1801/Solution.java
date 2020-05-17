package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream is = new FileInputStream(path);
        is.close();
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        byte max = bytes[0];
        for (int i = 1; i < bytes.length; i++) {
            if (bytes[i] > max) {
                max = bytes[i];
            }
        }
        System.out.println(max);
    }
}
