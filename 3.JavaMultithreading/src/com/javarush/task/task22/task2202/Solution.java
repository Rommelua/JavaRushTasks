package com.javarush.task.task22.task2202;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));

    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        String result = Arrays.stream(string.split(" ")).skip(1).limit(4).collect(Collectors.joining(" "));
        if (result.split(" ").length < 4) throw new TooShortStringException();
        return result;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
