package leetcode.editor.cn.productAndconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: ReentrantLock + condition (await/signal)
 * @author: Silince
 * @create: 2021-03-28 22:58
 **/
public class ProducerConsumer2 {

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

        private ReentrantLock lock =  new ReentrantLock();
        private Condition fullCondition = lock.newCondition();
        private Condition emptyCondition = lock.newCondition();

        public  void produce() {
            int i = 0;
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == CAPACITY) {
                        try {
                            System.out.println("仓库已满,["+Thread.currentThread().getName()+"]等待消费者消费 ");
                            fullCondition.await();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("[" + Thread.currentThread().getName() + "] 生产了 : +" + i);
                    queue.offer(i++ + "(由" + Thread.currentThread().getName() + "生产)");
                    // 唤醒其他所有生产者、消费者
                    fullCondition.signalAll();
                    emptyCondition.signalAll();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    try {
                        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public  void consume() {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("仓库空了,["+Thread.currentThread().getName()+"]等待生产");
                            emptyCondition.await();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    String s = queue.poll();
                    System.out.println("[" + Thread.currentThread().getName() + "] 消费了 : " + s);
                    //唤醒其他所有生产者、消费者
                    fullCondition.signalAll();
                    emptyCondition.signalAll();


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    try {
                        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
