package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static {
        String pathOne = "";
        String pathTwo = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            pathOne = reader.readLine();
            pathTwo = reader.readLine();
            Files.lines(Paths.get(pathOne)).forEach(allLines::add);
            Files.lines(Paths.get(pathTwo)).forEach(forRemoveLines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Solution().joinData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void joinData() throws IOException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
