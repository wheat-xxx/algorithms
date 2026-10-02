package java_basic.thread;

import org.junit.Test;

/**
 * @author wheat
 * @date 2024/10/13  16:47
 */
public class ThreadInterruptTest {

    @Test
    public void testInterrupt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // 模拟任务
                    System.out.println("thread-1 is running");
                    Thread.sleep(1000);  // 可中断的阻塞操作
                }
            } catch (InterruptedException e) {
                System.out.println("thread-1 was interrupted during sleep");
                // 可以选择处理中断逻辑，或者直接退出
                // ...
            }
            System.out.println("thread-1 exiting...");
        }, "thread-1");

        t1.start();
        Thread.sleep(3000);
        t1.interrupt();  // 中断thread-1
    }

}
