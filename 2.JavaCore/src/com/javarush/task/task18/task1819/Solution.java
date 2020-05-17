package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path1, path2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path1 = reader.readLine();
            path2 = reader.readLine();
        }
        byte[] data1, data2;
        try (BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(path1));
             BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(path2))) {
            data1 = new byte[bis1.available()];
            bis1.read(data1);
            data2 = new byte[bis2.available()];
            bis2.read(data2);

        }
        try (BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(path1))) {
            bos1.write(data2);
            bos1.write(data1);
        }
    }
}
