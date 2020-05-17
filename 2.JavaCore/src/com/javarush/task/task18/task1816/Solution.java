package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(args[0]);
        byte[] data = new byte[is.available()];
        is.read(data);

        int res = Files.lines(Paths.get(args[0]))
                .map(s -> s.replaceAll("[^A-Za-z]", ""))
                .mapToInt(String::length).sum();
        is.close();
        System.out.println(res);
    }
}
