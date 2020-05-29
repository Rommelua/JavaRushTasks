package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        Map<Date, Long> advProfitPerDays = StatisticManager.getInstance().getAdvProfitPerDays();
        if(advProfitPerDays == null || advProfitPerDays.isEmpty()) return;
        Locale.setDefault(Locale.ENGLISH);
        long sum = advProfitPerDays.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) //Сортируем стрим по дате в обратном порядке
                .peek(e -> ConsoleHelper.writeMessage(String //выводим в консоль все элементы
                        .format(Locale.ENGLISH,"%s - %.2f", DATE_FORMAT.format(e.getKey()), e.getValue() / 100.0)))
                .mapToLong(Map.Entry::getValue).sum(); //Получаем и выводим сумму
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"Total - %.2f", sum / 100.0));
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkloading = StatisticManager.getInstance().getCookWorkloading();
        if(cookWorkloading == null || cookWorkloading.isEmpty()) return;
        cookWorkloading.entrySet().stream()
            .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))//Сортируем стрим по дате в обратном порядке
            .forEach(entry -> {ConsoleHelper.writeMessage(DATE_FORMAT.format(entry.getKey()));//Выводим дату
                    entry.getValue().forEach((k, v) -> ConsoleHelper.writeMessage(String //Выводим всех поваров
                            .format("%s - %d min", k, v % 60 == 0 ? v / 60 : v / 60 + 1)));//перевод в минуты с округлением вверх
                    ConsoleHelper.writeMessage("");});// перевод строки
    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }
}
