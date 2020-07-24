package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Test {
    public static void main(String[] args) throws Exception {
        args = new String[]{"2.JavaCore/src/com/javarush/task/task19/task1925/test1.txt",
                "2.JavaCore/src/com/javarush/task/task19/task1925/test2.txt"};
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String stroka;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String toWrite="";
        while ((stroka = bufferedReader.readLine()) != null) {
            String[] splinter = stroka.trim().split(",");
            for (int i = 0; i < splinter.length; i++) {
                if (splinter[i].length()>6) {
                    toWrite = toWrite+splinter[i]+",";
                }
            }
        }
        toWrite = toWrite.substring(1);
        if (toWrite.endsWith(",")){
            toWrite = toWrite.substring(0,toWrite.length()-1);
        }
        while(toWrite.startsWith(" ")){
            toWrite = toWrite.substring(1);
        }
        bufferedWriter.write(toWrite);
        bufferedReader.close();
        bufferedWriter.close();
    }
}
