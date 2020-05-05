package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне1", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("JUNE 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        map.values().removeIf(d -> d.getMonth() > 4 && d.getMonth() < 8);

    }

    public static void main(String[] args) {

    }
}
