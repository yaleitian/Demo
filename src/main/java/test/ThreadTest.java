package test;

import com.springmvc.thread.Station;
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

        // 让每一个站台对象各自开始工作
        station1.start();
        station2.start();
        station3.start();
    }

}
