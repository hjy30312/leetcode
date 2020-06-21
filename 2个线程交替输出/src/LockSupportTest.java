import java.lang.reflect.AccessibleObject;
import java.util.concurrent.locks.LockSupport;

/**
 * 用两个线程，一个输出字母，一个输出数字，交替输出
 * 1A2B3C。。。
 * @author hjy
 * @date 2020/6/21 14:20
 */
public class LockSupportTest {

    static Thread t1 = null;
    static Thread t2 = null;
    static Thread t3 = null;

    public static void main(String[] args) {
        char[] aI = "aaa".toCharArray();
        char[] aC = "lll".toCharArray();
        char[] aD = "iii".toCharArray();

        t1 = new Thread(() -> {
           for (char c : aI) {
               System.out.print(c);
               // 叫醒T2
               LockSupport.unpark(t2);
               // 阻塞T1
               LockSupport.park();
           }
        }, "t1");

        t2 = new Thread(() -> {

            for (char c : aC) {
                // T2阻塞
                LockSupport.park();
                System.out.println(c);
                // 叫醒T1
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();

    }



}
