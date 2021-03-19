package leetcode.editor.cn.doc;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: LeetCode
 * @description: LockSupport实现锁
 * @author: Silince
 * @create: 2021-03-13 15:26
 **/
public class MyLockByLockSupport {
    private volatile int status = 0; // 锁状态

    private LinkedBlockingQueue<Thread> parkQueue = new LinkedBlockingQueue<>(); // 阻塞线程队列

    public void myLock(){
        // 自旋获取锁

    }
}
