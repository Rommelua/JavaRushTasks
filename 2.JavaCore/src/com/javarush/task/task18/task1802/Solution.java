package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream is = new FileInputStream(path);
        int min = is.read();
        while (is.available() > 0) {
            int temp = is.read();
            if (temp < min) {
                min = temp;
            }
        }
        is.close();
        System.out.println(min);
    }
}
