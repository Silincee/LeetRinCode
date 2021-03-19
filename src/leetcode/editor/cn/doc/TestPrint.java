package leetcode.editor.cn.doc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 多线程之间按顺序调用，实现 A-> B -> C 三个线程启动，要求如下：`AA打印5次，BB打印10次，CC打印15次`打印10轮
 * @author: Silince
 * @create: 2021-03-13 16:16
 **/
public class TestPrint {

    // 线程操作资源类   判断通知干活
    static class ShareResource {

        private int number = 1;  // A 1   B 2   c 3

        private Semaphore semaphoreA = new Semaphore(1);
        private Semaphore semaphoreB = new Semaphore(0);
        private Semaphore semaphoreC = new Semaphore(0);


        public void printA() throws InterruptedException {
            semaphoreA.acquire();
            System.out.println("A");
            semaphoreB.release();

        }

        public void printB() throws InterruptedException {
            semaphoreB.acquire();
            System.out.println("B");
            semaphoreC.release();
        }

        public void printC() throws InterruptedException {
            semaphoreC.acquire();
            System.out.println("C");
            semaphoreA.release();
        }
    }

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    shareResource.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    shareResource.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    shareResource.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}
