package com.javarush.task.task23.task2307;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Как выбрать нужное?
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = new TEST();
        System.out.println(obj);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    }
}
