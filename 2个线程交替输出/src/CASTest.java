/**
 * @author hjy
 * @date 2020/6/21 14:37
 */
public class CASTest {

    enum ReadyToRun {T1, T2}

    static  volatile  ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                // 自旋 空转
                while (r != ReadyToRun.T1) {}
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                // 自旋 空转
                while (r != ReadyToRun.T2) {}
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        }, "t2").start();



    }

}
