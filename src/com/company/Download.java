package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Download extends Thread{
    private CountDownLatch countDownLatch;
    private CountDownLatch countDownLatch1;
    private Semaphore semaphore;
    private int user;

    public Download(int user,Semaphore semaphore, CountDownLatch countDownLatch, CountDownLatch countDownLatch1){
        this.user=user;
        this.countDownLatch=countDownLatch;
        this.semaphore=semaphore;
        this.countDownLatch=countDownLatch1;
    }
    public void run(){
        try {
            countDownLatch1.await();
            semaphore.acquire();
            System.out.println("\n + скачивание файлов "+ user+ " чел");
            sleep(1000);
            System.out.println("\n файл скачан "+ user);
            semaphore.release();
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
