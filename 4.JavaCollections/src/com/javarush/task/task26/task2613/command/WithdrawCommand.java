package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand  implements Command {
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw", Locale.getDefault());
    @Override
    public void execute() throws InterruptOperationException {
        String currency = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        int sum;
        Map<Integer, Integer> withdrawn;
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try {
                sum = Integer.parseInt(ConsoleHelper.readString());
                if (!manipulator.isAmountAvailable(sum)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }
                withdrawn = manipulator.withdrawAmount(sum);
                break;
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
        withdrawn.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(e->ConsoleHelper.writeMessage("\t" + e.getKey() + " - " + e.getValue()));
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),sum ,currency));
    }
}
