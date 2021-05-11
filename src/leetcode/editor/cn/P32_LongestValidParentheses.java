//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1242 👎 0


package leetcode.editor.cn;

//最长有效括号

import java.util.Stack;

public class P32_LongestValidParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P32_LongestValidParentheses().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
		char[] chars = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		stack.push(-1);
		for (int i = 0; i < chars.length; i++) {
			// ( 压栈
			if (chars[i]=='('){
				stack.push(i);
			}else {
				stack.pop();
				if (stack.isEmpty()){
					stack.push(i);
				}else {
					res = Math.max(res, i - stack.peek());


				}
			}
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}