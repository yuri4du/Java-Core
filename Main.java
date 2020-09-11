package ru.geekbrains.lesson_d.HW;

public class Main {

    public static void main(String[] args) {
        new MyThread1().start();
        new MyThread2().start();
    }

    static class MyThread1 extends Thread {
        static final int size = 10000000;
        static final int h = size / 2;
        float[] arr = new float[size];


        @Override
        public synchronized void run() {
            for (int i = 0; i < size; i++) {
                arr[i] = 1;
            }
            long a = System.currentTimeMillis();
            System.out.println(currentThread().getName() + " startssss");
            for (int i = 0; i < size; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long b = System.currentTimeMillis();

            System.out.println(currentThread().getName() + " finishedddd");
            System.out.println(b-a);
        }
    }
}
