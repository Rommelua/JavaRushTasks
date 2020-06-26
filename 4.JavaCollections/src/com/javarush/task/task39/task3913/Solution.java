package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("D:\\Java\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get user for event = \"DONE_TASK\""));
        System.out.println(logParser.execute("get event for date = \"30.08.2012 16:08:40\""));
    }
}