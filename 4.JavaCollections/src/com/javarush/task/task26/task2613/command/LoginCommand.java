package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private final ResourceBundle validCreditCards
            = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards", Locale.getDefault());
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login", Locale.getDefault());
    @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumberText = ConsoleHelper.readString();
            String pinText = ConsoleHelper.readString();
            if (cardNumberText.matches("\\d{12}") && pinText.matches("\\d{4}")) {
                ConsoleHelper.writeMessage(res.getString("before"));
                if (validCreditCards.containsKey(cardNumberText) && validCreditCards.getString(cardNumberText).equals(pinText)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumberText));
                    return;
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumberText));
                }
            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
