package test;

import com.springmvc.thread.*;
import org.junit.Test;

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
    public synchronized void testBank(){

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

}
