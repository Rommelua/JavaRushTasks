package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> files = new ArrayList<>();
        String path;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(path = reader.readLine()).equals("end")) {
                files.add(path);
            }
        }
        files.sort(Comparator.comparingInt(a -> Integer.parseInt(a.replaceAll(".+\\.part", ""))));
        String fileName = files.get(0).substring(0, files.get(0).lastIndexOf(".part"));
//        for (String f : files) {
//            Files.write(Paths.get(fileName), Files.readAllBytes(Paths.get(f)), StandardOpenOption.APPEND);
//        }
        //Files.createFile(Paths.get(fileName));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName, true));

        for (String f : files) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
            bis.close();
            bos.flush();
        }
        bos.close();

    }
}
