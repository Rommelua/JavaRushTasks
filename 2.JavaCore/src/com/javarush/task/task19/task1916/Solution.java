package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String path1, path2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            path1 = reader.readLine();
            path2 = reader.readLine();
        }
        List<String> file1, file2;
        try (BufferedReader reader1 = new BufferedReader(new FileReader(path1));
        BufferedReader reader2 = new BufferedReader(new FileReader(path2))){
            file1 = reader1.lines().collect(Collectors.toList());
            file2 = reader2.lines().collect(Collectors.toList());
        }
        int j = 0;
        for (int i = 0; i < file1.size(); i++) {
            if (j < file2.size() && file1.get(i).equals(file2.get(j))) {
                lines.add(new LineItem(Type.SAME, file1.get(i)));
                j++;
            } else if (j < file2.size() && file1.get(i).equals(file2.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, file2.get(j)));
                j++;
                i--;
            } else {
                lines.add(new LineItem(Type.REMOVED, file1.get(i)));
            }
        }
        for (; j < file2.size(); j++) {
            lines.add(new LineItem(Type.ADDED, file2.get(j)));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
