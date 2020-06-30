package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit", Locale.getDefault());
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] numbers = ConsoleHelper.getValidTwoDigits(currencyCode);
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int faceValue = Integer.parseInt(numbers[0]);
        int quantity = Integer.parseInt(numbers[1]);
        manipulator.addAmount(faceValue, quantity);
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), faceValue * quantity, currencyCode));
    }
}
