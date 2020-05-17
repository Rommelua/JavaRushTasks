package com.javarush.task.task18.task1823;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        String path;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(path = reader.readLine()).equals("exit")) {
                new ReadThread(path);
            }
        }
    }

    public static class ReadThread extends Thread {
        String path;

        public ReadThread(String fileName) {
            path = fileName;
            start();
        }

        @Override
        public void run() {
            List<Integer> list = new ArrayList<>();
            try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(path))) {
                while (is.available() > 0) {
                    list.add(is.read());
                }
            }catch (IOException e) {}
            List<Integer> frequency = new ArrayList<>(list.size());
            for (Integer i : list) {
                frequency.add(Collections.frequency(list, i));
            }
            int bbyte = list.get(frequency.indexOf(Collections.max(frequency)));
            synchronized (resultMap) {
                resultMap.put(path, bbyte);
            }
        }
    }
}
