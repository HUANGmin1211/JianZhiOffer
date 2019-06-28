package nowcoder;

import java.util.concurrent.*;

public class TestCyclicBarrier {

    public static void main(String[] args) {
        // 都到达屏障后，先执行构造函数里面的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("all work down");
            }
        });

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 6; i++) {
            pool.submit(new ThreadWithCyclicBarrier(i, cyclicBarrier));
        }
        pool.shutdown();
    }
}

class ThreadWithCyclicBarrier implements Runnable {

    int id;
    CyclicBarrier cyclicBarrier;

    public ThreadWithCyclicBarrier(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("thread id = " + id + ", start");
        try {
            cyclicBarrier.await();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("thread id = " + id + ", end");

    }
}
