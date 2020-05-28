package com.javarush.task.task28.task2811;

/* 
ReentrantReadWriteLock
*/

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Solution {
    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(5, 1, false);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "c");
        map.put(2, "d");
        map.put(1, "f");
        map.get(3);
        map.get(3);
        map.get(3);
        map.get(5);
        System.out.println(map);
    }
}
