package ThreadTest;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i < 6; i++) {
            new Thread(new ThreadWithCountDownLatch(i, countDownLatch)).start();
        }

        try {
            countDownLatch.await(); // 等到下面都执行了，await这里才会执行
            System.out.println("终于到我了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class ThreadWithCountDownLatch implements Runnable {

    private int id;
    private CountDownLatch countDownLatch;

    public ThreadWithCountDownLatch(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + id + " start~");
            Thread.sleep(2000);
            countDownLatch.countDown();
//            System.out.println("Thread " + id + " end~");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
