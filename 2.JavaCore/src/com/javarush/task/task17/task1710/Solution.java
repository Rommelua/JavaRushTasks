package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatRead = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c":
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], formatRead.parse(args[3])));
                } else allPeople.add(Person.createFemale(args[1], formatRead.parse(args[3])));
                System.out.println(allPeople.size() - 1);

                break;
            case "-u":
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(args[2]);
                if (args[3].equals("м")){
                    allPeople.get(id).setSex(Sex.MALE);
                } else allPeople.get(id).setSex(Sex.FEMALE);
                allPeople.get(id).setBirthDate(formatRead.parse(args[4]));
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDate(null);
                break;
            case "-i":
                id = Integer.parseInt(args[1]);
                System.out.println(allPeople.get(id));
        }
    }
}
