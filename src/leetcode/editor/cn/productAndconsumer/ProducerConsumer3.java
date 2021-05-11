package leetcode.editor.cn.productAndconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 阻塞队列
 * @author: Silince
 * @create: 2021-03-28 22:58
 **/
public class ProducerConsumer3 {

    public static void main(String args[]) {
        Storage storage = new Storage();

        new Thread(storage::produce, "生产者P1").start();
        new Thread(storage::produce, "生产者P2").start();
        new Thread(storage::produce, "生产者P3").start();
        new Thread(storage::consume, "消费者C1").start();
        new Thread(storage::consume, "消费者C2").start();
        new Thread(storage::consume, "消费者C3").start();

    }

    /**
     * 仓库/资源类
     */
    public static class Storage {
        // 设置队列缓存的大小。生产过程中超过这个大小就暂时停止生产
        private int CAPACITY = 5;
        // 仓库存储的载体
        private LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(CAPACITY);


        public void produce() {
            int i = 0;
            while (true) {
                try {
                    blockingQueue.put(i++ + "(由" + Thread.currentThread().getName() + "生产)");
                    System.out.println(blockingQueue.size());
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void consume() {
            while (true) {
                try {
                    String s = blockingQueue.take();
                    System.out.println("[" + Thread.currentThread().getName() + "] Consuming : " + s);

                    //暂停最多1秒
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
