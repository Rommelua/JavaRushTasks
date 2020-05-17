package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path1, path2, path3;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path1 = reader.readLine();
            path2 = reader.readLine();
            path3 = reader.readLine();
        }
//        Files.write(Paths.get(path1), Files.readAllBytes(Paths.get(path2)));
//        Files.write(Paths.get(path1), Files.readAllBytes(Paths.get(path3)), StandardOpenOption.APPEND);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path1, true));
            BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(path2));
            BufferedInputStream bis3 = new BufferedInputStream(new FileInputStream(path3))) {
            int data;
            while ((data = bis2.read()) != -1){
                bos.write(data);
            }
            while ((data = bis3.read()) != -1){
                bos.write(data);
            }
        }
    }
}
