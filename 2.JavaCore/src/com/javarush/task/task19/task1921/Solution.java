package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        //args = new String[]{"D:\\Java\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1921\\test.txt"};
        SimpleDateFormat format = new SimpleDateFormat("dMyyyy");
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            reader.lines().forEach(s -> {
                try {
                    PEOPLE.add(new Person(s.replaceAll("\\d", "").trim(),
                            format.parse(s.replaceAll("\\D", ""))));
                } catch (ParseException e) {}
            });
        }
    }
}
