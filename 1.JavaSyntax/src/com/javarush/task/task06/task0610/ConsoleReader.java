package com.javarush.task.task06.task0610;

/* 
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() - читает с клавиатуры строку
int readInt() - читает с клавиатуры число
double readDouble() - читает с клавиатуры дробное число
boolean readBoolean() - читает с клавиатуры строку "true" или "false" и возвращает
соответствующую логическую переменную true или false
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static int readInt() throws Exception {

        return Integer.parseInt(readString());
    }

    public static double readDouble() throws Exception {
        return Double.parseDouble(readString());

    }

    public static boolean readBoolean() throws Exception {
        return readString().equals("true");

    }

    public static void main(String[] args) throws Exception {

    }
}
