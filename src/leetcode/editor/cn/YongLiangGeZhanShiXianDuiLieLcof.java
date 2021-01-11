//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 149 👎 0


package leetcode.editor.cn;

//用两个栈实现队列

import java.util.LinkedList;

public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        //测试代码

    }

    //力扣代码 https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-2/
    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        LinkedList<Integer> A, B;

        /** 
        * @description: 一个队列具备的两个功能分别由两个栈来完成：栈A实现入队功能，栈B实现出队功能 
        */ 
        public CQueue() {
            // 栈 A 用于加入队尾操作，栈 B 用于将元素倒序，从而实现删除队首元素。
            A= new LinkedList<Integer>();
            B= new LinkedList<Integer>();
        }

        /** 
        * @description: 在队列尾部插入整数
        */ 
        public void appendTail(int value) {
            A.addLast(value);
        }

        /** 
        * @description: 在队列头部删除整数的
         */ 
        public int deleteHead() {
            if (!B.isEmpty()) return B.removeLast();
            if (A.isEmpty()) return -1;
            while (!A.isEmpty()){
                B.addLast(A.removeLast());
            }
            return B.removeLast();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}