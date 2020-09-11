package ru.geekbrains.lesson_d.HW;

public class  MyThread2 extends Thread {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];
    float[] a1 = new float[h];
    float[] a2 = new float[h];

    @Override
    public synchronized void run() {
        System.out.println(currentThread().getName() + " starts");
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();


        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        new MyThread3().start();
        new MyThread4().start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);


        long b = System.currentTimeMillis();
        System.out.println(currentThread().getName() + " finished");
        System.out.println(b-a);
    }

    public class MyThread3 extends Thread {

        @Override
        public synchronized void run() {
            System.out.println(currentThread().getName() + " starts");
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println(currentThread().getName() + " finished");
        }
    }

    public class MyThread4 extends Thread {

        @Override
        public synchronized void run() {
            System.out.println(currentThread().getName() + " starts");
            for (int i = 0; i < h; i++) {
                a2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println(currentThread().getName() + " finished");
        }
    }
}
