package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        String entry = "";
        List<Dish> result = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Enter dish you have chosen ('exit' for stop ordering):");
        while (!(entry = reader.readLine()).equals("exit")) {
            try {
                result.add(Dish.valueOf(entry));
            } catch (IllegalArgumentException e) {
                writeMessage("We don't have this dish in the menu, repeat your entry:");
            }
        }
        return result;
    }
}
