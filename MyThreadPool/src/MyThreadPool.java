import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单线程池实现
 */
public class MyThreadPool {

    /*
     * 存放线程的集合
     */
    private ArrayList threads;
    // 任务队列
    private ArrayBlockingQueue<Runnable> taskQueue;
    // 线程池初始化大小
    private int threadNum;
    // 已经工作的线程数目
    private int workThreadNum;

    private final ReentrantLock mainLock = new ReentrantLock();

    public MyThreadPool(int initPoolNum) {
        threadNum = initPoolNum;
        threads = new ArrayList(initPoolNum);
        // 任务队列初始化为线程池数的四倍
        taskQueue = new ArrayBlockingQueue<>(initPoolNum * 4);
        // 初始化, 工作线程为0
        workThreadNum = 0;
    }



    public void execute(Runnable runnable) {
        mainLock.lock();
        try {
            if (workThreadNum < threadNum) {
                // 线程池未满，每加入一个任务则开启一个线程
                MyThread myThread = new MyThread(runnable);
                myThread.start();
                threads.add(myThread);
                workThreadNum++;
            } else {
                // 线程池已满，加入任务队列
                if (!taskQueue.offer(runnable)) {
                    // 满则拒绝
                    rejectTask();
                }
            }
        } finally {
            mainLock.unlock();
        }
    }
    private void rejectTask() {
        System.out.println("任务队列已满，无法继续添加，请扩大您的初始化线程池！");
    }

    class MyThread extends Thread {
        private Runnable task;

        public MyThread(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            // 该线程一直启动着， 不断从任务队列中取出任务执行
            for(;;) {
                // 如果初始化任务不为空，则执行初始化任务
                if (task != null) {
                    task.run();
                    task = null;
                } else {
                    //获取任务队列中的任务执行
                    Runnable queueTask = taskQueue.poll();
                    if (queueTask != null) {
                        queueTask.run();
                    }
                }
            }
        }
    }

}
