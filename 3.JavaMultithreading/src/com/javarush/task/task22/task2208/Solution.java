package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* 
Формируем WHERE
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
{name=Ivanov, country=Ukraine, city=Kiev, age=null}
*/
public class Solution {
    public static void main(String[] args) {
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("name", "Ivanov");
//        map.put("country", "Ukraine");
//        map.put("city", "Kiev");
//        map.put("age", null);
//        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder(); //Валька, привет!!!
        return params.entrySet().stream().filter(entry -> entry.getValue() != null)
                .map(entry -> String.format("%s = '%s'", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" and "));
    }
}
