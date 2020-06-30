package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private final static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    private final static ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common", Locale.getDefault());

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String text = bis.readLine();
            if(text.equalsIgnoreCase(res.getString("operation.EXIT"))) throw new InterruptOperationException();
            return text;
        } catch (IOException e) {
            return "";
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String code = readString();
        if (code.length() == 3) {
            return code.toUpperCase();
        }else {
            writeMessage(res.getString("invalid.data"));
            return askCurrencyCode();
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        String s = readString();
        if (s.matches("\\d+ \\d+")) {
            return s.split(" ");
        } else {
            writeMessage(res.getString("invalid.data"));
            return getValidTwoDigits(currencyCode);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage("1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
        try {
            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        } catch (IllegalArgumentException e) {
            return askOperation();
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
