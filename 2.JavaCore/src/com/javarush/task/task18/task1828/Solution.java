package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        //args = new String[]{"-d", "19847"};
        if (args == null || args.length == 0){
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileReader fr = new FileReader(path);
        fr.close();
        if (args[0].equals("-u")) {
            update(path, args);
        }
        if (args[0].equals("-d")) {
            delete(path, args);
        }
    }
    private static void update(String path, String[] args) throws IOException {
        final String FORMAT = "%-8d%-30s%-8.2f%-4d";
        int id = Integer.parseInt(args[1]);
        String newLine = String.format(FORMAT, id, args[2],
                Double.parseDouble(args[3].trim()) , Integer.parseInt(args[4].trim()));
        String data = Files.lines(Paths.get(path))
                .map(s -> Integer.parseInt(s.substring(0, 8).trim()) == id ? newLine : s)
                .collect(Collectors.joining("\n"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
        }
    }
    private static void delete(String path, String[] args) throws IOException {
        int id = Integer.parseInt(args[1]);
        String data = Files.lines(Paths.get(path)).filter(s -> Integer.parseInt(s.substring(0, 8).trim()) != id)
                .collect(Collectors.joining("\n"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
        }
    }
}
