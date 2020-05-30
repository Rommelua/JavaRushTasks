package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public class DirectorTablet {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

        public void printAdvertisementProfit() {
        Map<Date, Long> advProfitPerDays = StatisticManager.getInstance().getAdvProfitPerDays();
        if(advProfitPerDays == null || advProfitPerDays.isEmpty()) return;
        long sum = advProfitPerDays.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) //Сортируем стрим по дате в обратном порядке
                .peek(e -> ConsoleHelper.writeMessage(String //выводим в консоль все элементы
                        .format("%s - %.2f", DATE_FORMAT.format(e.getKey()), e.getValue() / 100.0)))
                .mapToLong(Map.Entry::getValue).sum(); //Получаем и выводим сумму
        ConsoleHelper.writeMessage(String.format("Total - %.2f", sum / 100.0));
        ConsoleHelper.writeMessage("");
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkloading = StatisticManager.getInstance().getCookWorkloading();
        if (cookWorkloading == null || cookWorkloading.isEmpty()) return;
        cookWorkloading.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))//Сортируем стрим по дате в обратном порядке
                .forEach(entry -> {
                    ConsoleHelper.writeMessage(DATE_FORMAT.format(entry.getKey()));//Выводим дату
                    entry.getValue().forEach((k, v) -> ConsoleHelper.writeMessage(String //Выводим всех поваров
                            .format("%s - %d min", k, v)));//перевод в минуты с округлением вверх
                });// перевод строки
        ConsoleHelper.writeMessage("");
    }

    public void printActiveVideoSet() {
        StatisticAdvertisementManager.getInstance().getActiveVideos().stream()
                .sorted(Comparator.comparing(Advertisement::getName, String::compareToIgnoreCase))
                .forEach(v -> ConsoleHelper.writeMessage(v.getName() + " - " + v.getHits()));
        ConsoleHelper.writeMessage("");
    }

    public void printArchivedVideoSet() {
        StatisticAdvertisementManager.getInstance().getArchivedVideos().stream()
                .sorted(Comparator.comparing(Advertisement::getName, String::compareToIgnoreCase))
                .forEach(v -> ConsoleHelper.writeMessage(v.getName()));
        ConsoleHelper.writeMessage("");
    }
}
