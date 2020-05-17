package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName = args[1];
        String fileOutputName = args[2];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileOutputName))) {
            byte[] data = new byte[bis.available()];
            bis.read(data);
            bis.close();
            for (int i = 0; i < data.length; i++) {
                if (args[0].equals("-e")) {
                    data[i] += 7;
                } else if (args[0].equals("-d")) {
                    data[i] -= 7;
                }
            }
            bos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
