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

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 5;
    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 10;
    /**
     * 任务队列容量
     */
    private static final int QUEUE_CAPACITY = 100;
    /**
     * 当线程数大于 corePoolSize 时，多余的线程在空闲时保持存活的时间
     */
    private static final Long KEEP_ALIVE_TIME = 1L;

    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        // 通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),   // 任务队列 - 有界阻塞队列，容量固定
                new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略 - 调用者线程执行被拒绝的任务，避免任务丢失

        for (int i = 0; i < 10; i++) {
            // 执行任务
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " start-time=" + LocalDateTime.now());
                try {
                    // 模拟任务处理
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end-time=" + LocalDateTime.now());
            });
        }

        // 终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
            // 等待线程池关闭
        }
        System.out.println("Finished all threads");
    }

}
