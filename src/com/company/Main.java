package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Uploader uploader = new Uploader(countDownLatch);
        uploader.start();
        Semaphore semaphore = new Semaphore(3, true);
        CountDownLatch countDownLatch1 = new CountDownLatch(10);

        for (int i = 1; i < 11; i++) {
            new Download(i, semaphore, countDownLatch, countDownLatch1).start();
            Thread.sleep(1000);
        }
        countDownLatch.await();
        System.out.println("файлы удалены с сервера");
    }
}
