package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("LastName" + i, 495 + i);
        }
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        map.values().removeIf(i -> i < 500);
    }

    public static void main(String[] args) {

    }
}