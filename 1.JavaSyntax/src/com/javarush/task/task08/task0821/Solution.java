package com.javarush.task.task08.task0821;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Сталлоне", "name1");
        map.put("Сталлоне1", "name2");
        map.put("Сталлоне2", "name2");
        map.put("Сталлоне3", "name3");
        map.put("Сталлоне4", "name3");
        map.put("Сталлоне5", "name4");
        map.put("Сталлоне6", "name5");
        map.put("Сталлоне7", "name6");
        map.put("Сталлоне", "name6");
        map.put("Сталлоне", "name7");
        return map;

    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
