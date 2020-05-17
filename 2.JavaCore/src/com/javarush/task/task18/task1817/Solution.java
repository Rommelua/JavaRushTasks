package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
//        int allCharsQuantity = Files.lines(Paths.get(args[0]))
//                .mapToInt(String::length).sum();
        FileInputStream fis = new FileInputStream(args[0]);
        int allCharsQuantity = fis.available();
        fis.close();
        int spaceQuantity = Files.lines(Paths.get(args[0]))
                .map(s -> s.replaceAll("[^ ]", ""))
                .mapToInt(String::length).sum();
        double res = (double) spaceQuantity / allCharsQuantity * 100;
        Locale.setDefault(Locale.US);
        System.out.printf("%.2f", res);
    }
}
