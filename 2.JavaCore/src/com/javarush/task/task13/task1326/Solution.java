package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();
        BufferedReader fis = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        int i;
        List<Integer> list = new ArrayList<>();
        while ((line = fis.readLine()) != null) {
            if((i = Integer.parseInt(line)) % 2 == 0) {
                list.add(i);
            }
        }
        fis.close();
        list.stream().sorted().forEach(System.out::println);
//        BufferedReader fileReader = new BufferedReader(new FileReader(path));
//        fileReader.lines().mapToInt(Integer::parseInt).filter(i -> i % 2 == 0)
//                .sorted().forEach(System.out::println);
//        fileReader.close();
    }
}
