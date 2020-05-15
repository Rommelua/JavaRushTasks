package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {

    public static void main(String[] args)  {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        //myThread.join();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);
        }
        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                String s = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                System.out.println(s);
            }
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

