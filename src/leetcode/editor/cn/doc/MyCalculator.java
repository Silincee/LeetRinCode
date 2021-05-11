package leetcode.editor.cn.doc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 实现一个计算器
 * @author: Silince
 * @create: 2021-04-10 11:00
 **/
public class MyCalculator {
    public static void main(String[] args) throws Exception {
        System.out.println(new MyCalculator().calculate("(1+ 2*(3-(-1)))/5"));
        System.out.println((1 + 2 * (3 - 1)) / 5);
    }

    private int calculate(String s) throws Exception {
        s = s.replace(" ", "");
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        return helper(queue);
    }

    private int helper(Queue<Character> queue){
        Stack<Integer> stack = new Stack<>();
        int num = 0; // 记录算式中的数字
        char sign = '+'; // 记录 num 前的符号，初始化为 +
        while (!queue.isEmpty()) {
            char c = queue.poll();
            // 如果是数字，连续读取到 num
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0'); // 括号不能省略，否则可能造成整型溢出
            }
            // 括号包含的算式，我们直接视为一个数字就行了。
            // 遇到 '(' 开始递归，遇到 ')' 结束递归
            if (c == '(') {
                num = helper(queue);
            }

            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中,另外当i走到了算式的尽头，也应该将前面的数字入栈，方便后续计算最终结果
            if (!Character.isDigit(c) || queue.isEmpty()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
            // 遇到右括号返回递归结果
            if (c == ')') {
                break;
            }
        }

        // 将栈中所有结果求和就是答案
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }


}
