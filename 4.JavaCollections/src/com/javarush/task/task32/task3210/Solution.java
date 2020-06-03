package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rv");
        raf.seek(Long.parseLong(args[1]));
        String text = args[2];
        byte[] bytes = new byte[text.length()];
        raf.read(bytes, 0, bytes.length);
        raf.seek(raf.length());
        if (new String(bytes).equals(text)) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }
    }
}
