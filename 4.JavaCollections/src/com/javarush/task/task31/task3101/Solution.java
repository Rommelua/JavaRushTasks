package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File folder = new File(args[0]);
        File source = new File(args[1]);
        File destination = new File(source.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(source, destination);
        FileInputStream inputStream;
        Map<String, String> map = new TreeMap<>();
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue, folder.listFiles());

        while (!queue.isEmpty()){
            File currentFile = queue.remove();
            if (currentFile.isDirectory()){
                Collections.addAll(queue, currentFile.listFiles());
            }else if(currentFile.length()<=50) {
                map.put(currentFile.getName(), currentFile.getAbsolutePath());
            }
        }


        FileOutputStream fileOutputStream = new FileOutputStream(destination, true);
        for (Map.Entry<String, String> value : map.entrySet()){
            inputStream = new FileInputStream(value.getValue());
            byte[] buff = new byte[inputStream.available()];
            int count = inputStream.read(buff);
            fileOutputStream.write(buff);
            fileOutputStream.write("\n".getBytes());
            inputStream.close();
        }
        fileOutputStream.close();
    }
//    public static void main(String[] args) throws IOException {
////        args = new String[]{"D:\\Java\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3101\\dir",
////                "D:\\Java\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\Content.txt"};
//        Path pathForWalk = Paths.get(args[0]);
//        List<Path> filesToWrite = new ArrayList<>();
//        File result = new File(args[1]);
//        final String separ = File.separator;
//        File dest = new File(result.getParent() + separ + "allFilesContent.txt");
//        FileUtils.renameFile(result, dest);
//
//        Path resultPath = dest.toPath();
//        class MyFileVisitor extends SimpleFileVisitor<Path> {
//            @Override
//            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                if (Files.isRegularFile(file) && Files.size(file) <= 50) {
//                    filesToWrite.add(file);
//                }
//                return FileVisitResult.CONTINUE;
//            }
//        }
//        Files.walkFileTree(pathForWalk, new MyFileVisitor());
//        filesToWrite.sort(Comparator.comparing(Path::getFileName));
//        for (Path path : filesToWrite) {
//            List<String> data = Files.readAllLines(path);
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dest, true))) {
//                for (String s : data) {
//                    writer.write(s + "\n");
//                }
//            }
////            Files.write(resultPath, data, StandardOpenOption.APPEND);
//        }
//    }
}