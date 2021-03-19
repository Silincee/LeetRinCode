package leetcode.editor.cn.doc;

import java.util.concurrent.TimeUnit;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2021-03-13 17:33
 **/
public class WaitTest {
    private static int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            // method
            synchronized (WaitTest.class){
                System.out.println("A1");
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A2");
            }
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

        new Thread(() -> {
            // method
            synchronized (WaitTest.class){
                System.out.println("B1");

                System.out.println("B2");
            }
        }, "B").start();
    }
}
