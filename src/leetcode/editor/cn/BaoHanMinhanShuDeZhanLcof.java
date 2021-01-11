//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 72 👎 0


package leetcode.editor.cn;

//包含min函数的栈

import java.util.Stack;

public class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        //测试代码
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

         Stack<Integer> A, B;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            //栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
            A = new Stack<>();
            // 栈 B 中存储栈 A 中所有 非严格降序 的元素，则栈 A 中的最小元素始终对应栈 B 的栈顶元素，即 min() 函数只需返回栈 B 的栈顶元素即可。
            B = new Stack<>();

        }

        public void push(int x) {
            A.add(x);
            if (B.peek()==null||x<B.peek()){
                B.add(x);
            }
        }

        /**
        * @description: 重点为保持栈 A,B 的 元素一致性 。
        */
        public void pop() {
            // 执行栈 A 出栈（即 A.pop() ），将出栈元素记为 y ；
            Integer pop = A.pop();
            if (pop.equals(B.peek())){ // 若 y 等于栈 B 的栈顶元素，则执行栈 B 出栈（即 B.pop() ）。
                B.pop();
            }

        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}