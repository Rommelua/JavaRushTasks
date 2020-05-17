package com.javarush.task.task17.task1711;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private final static SimpleDateFormat READ_FORMAT = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    create(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    update(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    delete(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    printInfo(args);
                }
        }

    }

    private static void create(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 3) {
            if (args[i + 1].equals("м")) {
                allPeople.add(Person.createMale(args[i], READ_FORMAT.parse(args[i + 2])));
            } else allPeople.add(Person.createFemale(args[i], READ_FORMAT.parse(args[i + 2])));
            System.out.println(allPeople.size() - 1);
        }
    }

    private static void update(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 4) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(args[i + 1]);
            person.setSex(Sex.sexFor(args[i + 2]));
            person.setBirthDate(READ_FORMAT.parse(args[i + 3]));
        }
    }

    private static void delete(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }

    private static void printInfo(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            System.out.println(person);
        }
    }
}
