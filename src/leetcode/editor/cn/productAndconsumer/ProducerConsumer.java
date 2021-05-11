package leetcode.editor.cn.productAndconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: LeetCode
 * @description: wait/notify方式实现
 * @author: Silince
 * @create: 2021-03-28 22:58
 **/
public class ProducerConsumer {

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
        private Queue<String> queue = new LinkedList<>();

        public synchronized void produce() {
            int i = 0;
            while (true) {
                while (queue.size() == CAPACITY) {
                    try {
                        System.out.println("仓库已满,["+Thread.currentThread().getName()+"]等待消费者消费 ");
                        this.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("[" + Thread.currentThread().getName() + "] 生产了 : +" + i);
                queue.offer(i++ + "(由" + Thread.currentThread().getName() + "生产)");
                this.notifyAll();

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void consume() {
            while (true) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("仓库空了,["+Thread.currentThread().getName()+"]等待生产");
                        this.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                String s = queue.poll();
                System.out.println("[" + Thread.currentThread().getName() + "] 消费了 : " + s);
                this.notifyAll();

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
