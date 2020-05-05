package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //арбуз - ягода,
        map.put("арбуз", "ягода");
        //банан - трава,
        map.put("банан", "трава");
        //вишня - ягода,
        map.put("вишня", "ягода");
        //груша - фрукт,
        map.put("груша", "фрукт");
        //дыня - овощ,
        map.put("дыня", "овощ");
        //ежевика - куст
        map.put("ежевика", "куст");
        //жень-шень - корень,
        map.put("жень-шень", "корень");
        //земляника - ягода,
        map.put("земляника", "ягода");
        //ирис - цветок,
        map.put("ирис", "цветок");
        //картофель - клубень.
        map.put("картофель", "клубень");
        map.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
