package com.springmvc.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author tianyalei
 */
public class RunableName {

    public static void main(String[] args) throws Exception {
        System.out.println("使用线程池运行 Runnable 任务：");

        // 创建大小固定为 5 的线程池
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 手动创建线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();

        ExecutorService fixedThreadPool = new ThreadPoolExecutor(10,20,200L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);

        List<AccumRunnable> tasks = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            AccumRunnable task = new AccumRunnable(i * 10 + 1, (i + 1) * 10);
            tasks.add(task);

            // 让线程池执行任务 task
            fixedThreadPool.execute(task);
        }
        // 向线程池发送关闭的指令，等到已经提交的任务都执行完毕之后，线程池会关闭
        fixedThreadPool.shutdown();

        // 等待线程池关闭，等待的最大时间为 1 小时
        fixedThreadPool.awaitTermination(1, TimeUnit.HOURS);

        int total = 0;
        for (AccumRunnable task : tasks) {
            // 调用在 AccumRunnable 定义的 getResult 方法获得返回的结果
            total += task.getResult();
        }

        System.out.println("Total: " + total);
    }

    static final class AccumRunnable implements Runnable {

        private final int begin;
        private final int end;

        private int result;

        public AccumRunnable(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            result = 0;
            try {
                for (int i = begin; i <= end; i++) {
                    result += i;
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
            System.out.printf("(%s) - 运行结束，结果为 %d\n",
                    Thread.currentThread().getName(), result);
        }

        public int getResult() {
            return result;
        }
    }
}