package test;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLimit {

    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //速率是每秒只有3个许可    RateLimiter是Guava的一个限流组件，使用起来十分方便
        final RateLimiter rateLimiter = RateLimiter.create(3.0);

        for (int i = 0; i < 100; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        rateLimiter.acquire();
                        System.out.println("Accessing: " + no + ",time:"
                                + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            //执行线程
            exec.execute(runnable);
        }
        //退出线程池
        exec.shutdown();
    }
}
