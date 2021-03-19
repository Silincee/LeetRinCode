package leetcode.editor.cn.doc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 多线程之间按顺序调用，实现 A-> B -> C 三个线程启动，要求如下：`AA打印5次，BB打印10次，CC打印15次`打印10轮
 * @author: Silince
 * @create: 2021-03-13 16:16
 **/
public class SyncAndReentrantLockDemo {

    // 线程操作资源类   判断通知干活
    static class ShareResource {

        private int number = 1;  // A 1   B 2   c 3

        private ReentrantLock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();


        public void print5() {
            lock.lock();
            try {
                // 1判断 2干活 3通知
                while (number!=1){
                    conditionA.await();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
                }
                number=2;
                conditionB.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void print10() {
            lock.lock();
            try {
                // 1判断 2干活 3通知
                while (number!=2){
                    conditionB.await();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
                }
                number=3;
                conditionC.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void print15() {
            lock.lock();
            try {
                // 1判断 2干活 3通知
                while (number!=3){
                    conditionC.await();
                }
                for (int i = 0; i < 15; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" + i);
                }
                number=1;
                conditionA.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }
}
