package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread{
    private CountDownLatch countDownLatch;
    private int sizeOfFile=500;
    private int speedOfDownload=20;

    public Uploader (CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run(){
        try{
            for (int i = 0; i < 15; i++) {
                System.out.println("-");
                sleep(50);

            }
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
