package java_basic.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 确保 线程 1 先执行，线程 2 后执行
 * @author wheat
 * @date 2024/10/13  15:32
 */
public class ThreadSynchronizationTest {

    /**
     * join方法测试
     * @throws InterruptedException
     */
    @Test
    public void test_1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is running.");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 is running.");
        });

        t1.start();
        t1.join();  // 等待 t1 执行完毕
        t2.start();
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    // 同步锁
    private static final Object lock = new Object();
    // condition：标识 thread-1 是否运行结束
    private static boolean flag = false;

    /**
     * wait notify
     * @throws InterruptedException
     */
    @Test
    public void test_2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 1 is running");
                flag = true;
                lock.notify();
            }
        });

        Thread t2 = new Thread(() -> {
           synchronized (lock) {
               while (!flag) {
                   try {
                       lock.wait(); // 进入等待状态
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }

               System.out.println("Thread 2 is running");
           }
        });

        t2.start();
        Thread.sleep(1000L);
        t1.start();

        // 等待两个线程完成
        t1.join();
        t2.join();
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * CountDownLatch
     * @throws InterruptedException
     */
    @Test
    public void test_3() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
            latch.countDown(); // thread-1 执行完后减计数
        });

        Thread t2 = new Thread(() -> {
            try {
                latch.await(); // thread-2 等待，直到计数为0
                System.out.println("Thread 2 is running");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 启动 thread-1 thread-2
        t2.start();
        Thread.sleep(1000L);
        t1.start();

        // 等待线程完成
        t1.join();
        t2.join();
    }

}
