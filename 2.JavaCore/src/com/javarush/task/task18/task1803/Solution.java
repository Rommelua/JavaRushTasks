package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream is = new FileInputStream(path);
        List<Integer> list = new ArrayList<>();
        while (is.available() > 0) {
            list.add(is.read());
        }
        is.close();
        int maxOccurrence = list.stream().mapToInt(i -> Collections.frequency(list, i))
                .max().getAsInt();
        list.stream().filter(i -> Collections.frequency(list, i) == maxOccurrence).distinct()
                .forEach(i -> System.out.print(i + " "));
    }
}
