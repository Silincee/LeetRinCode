package leetcode.editor.cn.doc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2021-03-13 16:16
 **/
public class TestPrint2 {

    

    static Thread t1 = null;
    static Thread t2 = null;
    static Thread t3 = null;

    // 线程操作资源类   判断干活通知
    static class ShareResource {

        private int number = 1;  // A 1   B 2   c 3


        public  void printA() throws InterruptedException {
            // 判断
            while (number!=1){
                LockSupport.park();
            }
            // 干活
            System.out.println("A");
            // 通知
            number = 2;
        }

        public  void printB() throws InterruptedException {
            // 判断
            while (number!=2){
                LockSupport.park();
            }
            // 干活
            System.out.println("B");
            // 通知
            number = 3;
        }

        public  void printC() throws InterruptedException {
            // 判断
            while (number!=3){
                LockSupport.park();
            }
            // 干活
            System.out.println("C");
            // 通知
            number = 1;
        }
    }

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        t1=new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    shareResource.printA();
                    LockSupport.unpark(t2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A");

        t2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    shareResource.printB();
                    LockSupport.unpark(t3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        t3=new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    shareResource.printC();
                    LockSupport.unpark(t1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C");

        t1.start();
        t2.start();
        t3.start();
    }
}
