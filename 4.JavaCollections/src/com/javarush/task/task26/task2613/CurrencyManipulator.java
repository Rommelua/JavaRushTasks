package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private final String currencyCode;
    /**
     * Map<номинал, количество>
     */
    private Map<Integer, Integer> denominations = new TreeMap<>(Comparator.reverseOrder());

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count) {
        denominations.merge(denomination, count, Integer::sum);
    }

    public int getTotalAmount() {
        return denominations.entrySet().stream()
                .mapToInt(e -> e.getKey() * e.getValue())
                .sum();
    }

    public boolean hasMoney() {
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        for (int index = 0; index < denominations.size(); index++) {
            int sum = 0;
            List<Integer> faceValue = new ArrayList<>();
            List<Integer> quantity = new ArrayList<>();
            Map<Integer, Integer> result = new HashMap<>();
            denominations.forEach((k, v) -> {
                faceValue.add(k);
                quantity.add(v);
            });
            for (int i = index; i < faceValue.size(); i++) {
                while (sum < expectedAmount && faceValue.get(i) <= expectedAmount - sum
                        && quantity.get(i) > 0) {
                    sum += faceValue.get(i);
                    quantity.set(i, quantity.get(i) - 1);
                    result.merge(faceValue.get(i), 1, Integer::sum);
                }
                if (sum == expectedAmount) {
                    Map<Integer, Integer> newDenominations = new TreeMap<>(Comparator.reverseOrder());
                    for (int j = 0; j < faceValue.size(); j++) {
                        newDenominations.put(faceValue.get(j), quantity.get(j));
                    }
                    denominations = newDenominations;
                    return result;
                }
            }
        }
        throw new NotEnoughMoneyException();
    }
}
