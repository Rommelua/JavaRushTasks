package com.javarush.task.task08.task0815;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String
состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("LastName" + i, "FirstName" + i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        return Collections.frequency(map.values(), name);

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        if (map.containsKey(lastName))
            return 1;
        return 0;

    }

    public static void main(String[] args) {

    }
}
