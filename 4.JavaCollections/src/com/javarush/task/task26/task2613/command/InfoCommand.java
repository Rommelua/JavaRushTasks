package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Locale;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private final ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info", Locale.getDefault());
    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean hasMoney = CurrencyManipulatorFactory.getAllCurrencyManipulators().stream()
                .anyMatch(CurrencyManipulator::hasMoney);
        if (hasMoney) {
            CurrencyManipulatorFactory.getAllCurrencyManipulators()
                    .forEach(cm -> ConsoleHelper.writeMessage(cm.getCurrencyCode() + " - " + cm.getTotalAmount()));
        } else {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
