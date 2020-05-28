package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Locale.setDefault(Locale.ENGLISH);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        long sum = StatisticManager.getInstance().getAdvProfitPerDays().entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .peek(e -> ConsoleHelper.writeMessage(String
                        .format("%s - %.2f", dateFormat.format(e.getKey()), e.getValue() / 100.0)))
                .mapToLong(Map.Entry::getValue).sum();
        ConsoleHelper.writeMessage(String.format("Total - %.2f", sum / 100.0));
    }
    public void printCookWorkloading() {

    }
    public void printActiveVideoSet() {

    }
    public void printArchivedVideoSet() {

    }
}
