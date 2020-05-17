package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0 || !args[0].equals("-c")){
            return;
        }
        final String FORMAT = "%-8d%-30s%-8.2f%-4d";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileReader fr = new FileReader(path);
        fr.close();
        int id = Files.lines(Paths.get(path)).mapToInt(s -> Integer.parseInt(s.substring(0,8).trim()))
            .max().getAsInt() + 1;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.newLine();
            writer.write(String.format(FORMAT, id, args[1],
                    Double.parseDouble(args[2].trim()) , Integer.parseInt(args[3].trim())));
        }
    }
}
