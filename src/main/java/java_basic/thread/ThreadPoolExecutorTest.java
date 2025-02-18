package java_basic.thread;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wheat
 * @date 2024/07/01  15:52
 */
public class ThreadPoolExecutorTest {

    private static class MyRunnable implements Runnable {

        private String command;

        public MyRunnable(String s) {
            this.command = s;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start. Time = " + LocalDateTime.now());
            processCommand();
            System.out.println(Thread.currentThread().getName() + " End. Time = " + LocalDateTime.now());
        }

        private void processCommand() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return this.command;
        }
    }

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),   // 任务队列
                new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略

        for (int i = 0; i < 10; i++) {
            MyRunnable worker = new MyRunnable("" + i);
            // 执行Runnable
            executor.execute(worker);
        }

        // 终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }

}
