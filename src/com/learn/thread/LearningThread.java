package com.learn.thread;

public class LearningThread implements Runnable {
    int[] array = {0,1,2,3,4,5,6};
    int count = 0;

    public static void main(String[] args) throws Exception {
        LearningThread streams = new LearningThread();
        Thread t1 = new Thread(streams);
        Thread t2 = new Thread(streams);
        Thread t3 = new Thread(streams);
        t1.start();
        t1.join(500);
        t2.start();
        t2.join(500);
        t3.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            while(count < array.length) {
                System.out.println(Thread.currentThread().getName() + " - " +this.array[count]);
                if(count % 3 == 2) {
                    System.out.println(Thread.currentThread().getName() + " - notifying");
                    notifyAll();
                }
                try {
                    if(count % 3 < 3) {
                        System.out.println(Thread.currentThread().getName() + " - waiting");
                        count++;
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
