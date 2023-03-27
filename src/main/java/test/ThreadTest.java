package test;

import com.springmvc.thread.*;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author tianyalei
 */
public class ThreadTest {
    /**
     * java多线程同步锁的使用
     * 示例：三个售票窗口同时出售10张票
     * */
    @Test
    public void testStation() {
        Station station1 = new Station( "窗口1" );
        Station station2 = new Station( "窗口2" );
        Station station3 = new Station( "窗口3" );

        System.out.println(Thread.currentThread());
        // 让每一个站台对象各自开始工作
        station1.start();
        station2.start();
        station3.start();
        // 编写多线程Junit测试用例，就必须让主线程等待所有子线程执行完成后再退出，使用Thread.sleep()或者Thread.join(）方法。
        try {
            station1.join();
            station2.join();
            station3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 四个人ABCD通过一个账户A在柜台取钱和B在ATM机取钱C在ALIPAY花钱D在PAYPAL花钱
     * */
    @Test
    public void testBank(){

        long nano_startTime = System.nanoTime();
        long millis_startTime = System.currentTimeMillis();
        // 实力化一个银行对象
        Bank bank = new Bank();
        // 实例化四个人，传入同一个银行的对象
        PersonA persona = new PersonA(bank);
        PersonB personb = new PersonB(bank);
        PersonC personc = new PersonC(bank);
        PersonD persond = new PersonD(bank);
        // 四个人开始取钱
        persona.start();
        personb.start();
        personc.start();
        persond.start();
        // 编写多线程Junit测试用例，就必须让主线程等待所有子线程执行完成后再退出，使用Thread.sleep()或者Thread.join(）方法。
        try {
            persona.join();
            personb.join();
            personc.join();
            persond.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long nano_endTime = System.nanoTime();
        long millis_endTime = System.currentTimeMillis();
        System.out.println("Time taken in nano seconds: "
                + (nano_endTime - nano_startTime));
        System.out.println("Time taken in milli seconds: "
                + (millis_endTime - millis_startTime));
    }

    @Test
    public void testRunableName() throws InterruptedException {/*

        System.out.println("使用线程池运行 Runnable 任务：");

        // 创建大小固定为 5 的线程池
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 手动创建线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();

        ExecutorService fixedThreadPool = new ThreadPoolExecutor(10,20,200L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);

        List<RunableName.AccumRunnable> tasks = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            RunableName.AccumRunnable task = new RunableName.AccumRunnable(i * 10 + 1, (i + 1) * 10);
            tasks.add(task);

            // 让线程池执行任务 task
            fixedThreadPool.execute(task);
        }
        // 向线程池发送关闭的指令，等到已经提交的任务都执行完毕之后，线程池会关闭
        fixedThreadPool.shutdown();

        // 等待线程池关闭，等待的最大时间为 1 小时
        fixedThreadPool.awaitTermination(1, TimeUnit.HOURS);

        int total = 0;
        for (RunableName.AccumRunnable task : tasks) {
            // 调用在 AccumRunnable 定义的 getResult 方法获得返回的结果
            total += task.getResult();
        }

        System.out.println("Total: " + total);
    */}

    /**
     * 四个人ABCD通过一个账户A在柜台取钱和B在ATM机取钱C在ALIPAY花钱D在PAYPAL花钱
     * */
    @Test
    public void executorstBank(){

        long nano_startTime = System.nanoTime();
        long millis_startTime = System.currentTimeMillis();
        // 实力化一个银行对象
        Bank bank = new Bank();
        //ExecutorService executorService = Executors.newCachedThreadPool();
        // 使用Executors静态方法进行初始化
        ExecutorService service = Executors.newSingleThreadExecutor();

        // 实例化四个人，传入同一个银行的对象
        PersonA persona = new PersonA(bank);
        PersonB personb = new PersonB(bank);
        PersonC personc = new PersonC(bank);
        PersonD persond = new PersonD(bank);
        //service.submit( new Thread( persona ) );
        //service.submit( new Thread( personb ) );
        //service.submit( new Thread( personc ) );
        //service.submit( new Thread( persond ) );
        // 四个人开始取钱
        persona.start();
        personb.start();
        personc.start();
        persond.start();
        // 编写多线程Junit测试用例，就必须让主线程等待所有子线程执行完成后再退出，使用Thread.sleep()或者Thread.join(）方法。
        try {
            persona.join();
            personb.join();
            personc.join();
            persond.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long nano_endTime = System.nanoTime();
        long millis_endTime = System.currentTimeMillis();
        System.out.println("Time taken in nano seconds: "
                + (nano_endTime - nano_startTime));
        System.out.println("Time taken in milli seconds: "
                + (millis_endTime - millis_startTime));
    }

    @Test
    public void testForkJoin() throws ExecutionException, InterruptedException {
        ForkJoinExample example = new ForkJoinExample(1, 10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(example);
        System.out.println(result.get());
    }

    @Test
    public void testAnimal() {
        Tortoise tortoise = new Tortoise();
        Rabbit rabbit = new Rabbit();
        //回调方法的使用，谁先调用calltoback方法，另一个就不跑了
        LetOneStop letOneStop1 = new LetOneStop(tortoise);
        //让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
        rabbit.calltoback = letOneStop1;
        LetOneStop letOneStop2 = new LetOneStop(rabbit);
        //让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
        tortoise.calltoback = letOneStop2;
        //开始跑
        tortoise.start();
        rabbit.start();
        try {
            tortoise.join();
            rabbit.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testKfc() {
        // 只实例化一个KFC对象，保证每一个服务员和用户在同一个KFC对象内
        KFC kfc = new KFC();

        //实例化4个客户对象
        Customers c1 = new Customers(kfc);
        Customers c2 = new Customers(kfc);
        Customers c3 = new Customers(kfc);
        Customers c4 = new Customers(kfc);

        //实例化3个服务员对象
        Waiter waiter1 = new Waiter(kfc);
        Waiter waiter2 = new Waiter(kfc);
        Waiter waiter3 = new Waiter(kfc);

        //让所有的对象的线程都开始工作
        waiter1.start();
        waiter2.start();
        waiter3.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        try {
            c1.join();
            c2.join();
            c3.join();
            waiter1.join();
            waiter2.join();
            waiter3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThreadAddSub(){
        //创建一个存放ThreadAddSub对象的数组
        ThreadAddSub[] tSub=new ThreadAddSub[4];
        int i = 0;
        for ( i = 0; i < tSub.length; i++) {

            //把实例化ThreadAddSub对象赋值到数组内
            //第一三个是true，二四个是false
            tSub[i]=new ThreadAddSub(i%2==0?true:false);

            //让线程开始工作
            tSub[i].start();
        }
        for ( i = 0; i < tSub.length; i++) {
            try {
                tSub[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testThreadSum(){
        //创建一个存放ThreadAddSub对象的数组
        ThreadSum[] tSub=new ThreadSum[1];
        int i = 0;
        long nano_startTime = System.nanoTime();
        long millis_startTime = System.currentTimeMillis();
        for ( i = 0; i < tSub.length; i++) {

            //把实例化ThreadAddSub对象赋值到数组内
            //第一三个是true，二四个是false
            tSub[i]=new ThreadSum(1000);

            //让线程开始工作
            tSub[i].start();
        }

        for ( i = 0; i < tSub.length; i++) {
            try {
                tSub[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long nano_endTime = System.nanoTime();
        long millis_endTime = System.currentTimeMillis();
        System.out.println("Time taken in nano seconds: "
                + (nano_endTime - nano_startTime));
        System.out.println("Time taken in milli seconds: "
                + (millis_endTime - millis_startTime));
    }

}
