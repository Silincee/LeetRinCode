package leetcode.editor.cn.doc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: LeetCode
 * @description: CAS实现
 * @author: Silince
 * @create: 2021-03-13 15:15
 **/
public class MyLock {

    // 锁？ 抢占共享资源？ 原子引用
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock(){
        Thread thread = Thread.currentThread();
//        System.out.println(Thread.currentThread().getName()+"\t come in");
        // 自旋获取锁
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnlock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
//        System.out.println(Thread.currentThread().getName()+"\t invoked myunlock()");
    }

    public static void main(String[] args) {
        MyLock lock = new MyLock();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                // method
                lock.myLock();
                try {
                    try {
                        TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
                    // 1判断 2干活 3通知
                    System.out.println("Thread"+ finalI +"进入");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.myUnlock();
                    System.out.println("Thread"+ finalI +"释放锁");
                }
            }, String.valueOf(i)).start();
        }
    }

}
