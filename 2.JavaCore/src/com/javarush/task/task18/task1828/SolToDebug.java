package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SolToDebug {
    public static void main(String[] args) throws IOException {
        args = new String[]{"-u", "198478", "пляжные", "333", "33"};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        List<String> list = new ArrayList<>();
        reader.close();
        if (args[0].equals("-u")) {
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                String line = reader.readLine();
                list.add(line);
                if (!line.isEmpty()) {
                    int ind = Integer.parseInt(line.substring(0, 8).trim());
                    if (ind == Integer.parseInt(args[1])) {
                        String line1 = line.format("%-8s%-30.30s%-8s%-4s", args[1], args[2], args[3], args[4]);
                        list.remove(list.size() - 1);
                        list.add(line1);
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < list.size(); i++) {
                            writer.write(list.get(i) + "\n");
                        }
                        writer.close();
                        break;
                    }
                }
            }
            reader.close();
        }
        if (args[0].equals("-d")) {
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                String line = reader.readLine();
                list.add(line);
                if (!line.isEmpty()) {
                    int ind = Integer.parseInt(line.substring(0, 8).trim());
                    if (ind == Integer.parseInt(args[1])) {
                        list.remove(list.size() - 1);
                        FileWriter writer = new FileWriter(fileName);
                        for (int i = 0; i < list.size(); i++) {
                            writer.write(list.get(i) + "\n");
                        }
                        writer.close();
                        break;
                    }
                }
            }
            reader.close();
        }
    }
}
