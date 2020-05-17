package com.javarush.task.task16.task1616;

public class Account {
    private int value = 20_000_000;

    private synchronized void deposit(){
        for (int i = 0; i < 1_000_000; i++) {
            value += 1;
        }
    }
    private synchronized void withdraw(){
        for (int i = 0; i < 1_000_000; i++) {
            value -= 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        DepositThread depositThread = new DepositThread(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);
        depositThread.start();
        withdrawThread.start();
        depositThread.join();
        withdrawThread.join();
        System.out.println(account.value);
    }
    static class DepositThread extends Thread{
        private final Account account;

        DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            account.deposit();
        }
    }
    static class WithdrawThread extends Thread{
        private final Account account;

        WithdrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            account.withdraw();
        }
    }

}
