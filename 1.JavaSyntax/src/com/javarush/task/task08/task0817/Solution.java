package com.javarush.task.task08.task0817;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("LastName" + i, "FirstName" + i);
        }
        map.put("LastName", "FirstName" + 0);
        map.put("LastNameу",  "FirstName" + 0);
        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Set<String> duplicates = map.values().stream()
                .filter(v -> Collections.frequency(map.values(), v) > 1)
                .collect(Collectors.toSet());
        map.values().removeAll(duplicates);
        removeItemFromMapByValue(new HashMap<>(), null);
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(createMap().toString());
//        Map<String, String> map = createMap();
//        removeTheFirstNameDuplicates(map);
//        System.out.println(map.toString());
    }
}
