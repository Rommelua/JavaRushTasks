package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rv");
        long offset = Math.min(Long.parseLong(args[1]), raf.length());
        raf.seek(offset);
        raf.write(args[2].getBytes(StandardCharsets.UTF_8));
        raf.close();
    }
}
