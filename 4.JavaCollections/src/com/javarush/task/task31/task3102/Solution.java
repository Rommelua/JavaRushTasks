package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
//        List<String> result = new ArrayList<>();
//        Queue<File> queue = new PriorityQueue<>();
//        File dir = new File(root);
//        Collections.addAll(queue, dir.listFiles());
//        while (!queue.isEmpty()) {
//            File file = queue.poll();
//            if (file.isDirectory()) {
//                Collections.addAll(queue, file.listFiles());
//            } else result.add(file.getAbsolutePath());
//        }
        return Files.walk(Paths.get(root)).filter(Files::isRegularFile)
                .map(Path::toString).collect(Collectors.toList());
        //return result;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(getFileTree
//                ("D:\\Java\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3101\\dir"));
        Path f = Paths.get("C:\\Users\\Leonid\\AppData\\Local\\Temp\\temp-15103594567950215146.tmp");

        Files.delete(f);
    }
}
