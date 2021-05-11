//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1678 👎 0


package leetcode.editor.cn;

//括号生成

import java.util.LinkedList;
import java.util.List;

public class P22_GenerateParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P22_GenerateParentheses().new Solution();
	 	 solution.generateParenthesis(4);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 	private LinkedList<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
		int[] arr = new int[2]; // 描述当前括号的状态[左括号数量，右括号数量]
		StringBuilder list = new StringBuilder();
		backtrack(arr,list,n);
    	return res;
    }

	private void backtrack(int[] arr, StringBuilder list,int max) {
    	if (arr[0]<arr[1]){
    		return;
		}
    	if (arr[0]==max&&arr[1]==max){

			res.add(list.toString());
			return;
		}

    	// (
		if (arr[0]<=max){
			arr[0] = arr[0]+1;
			list.append('(');
			backtrack(arr,list,max);
			list.deleteCharAt(list.length()-1);
			arr[0] = arr[0]-1;
		}


    	// )
		if (arr[1]<=max){
			arr[1] = arr[1]+1;
			list.append(')');
			backtrack(arr,list,max);
			list.deleteCharAt(list.length()-1);
			arr[1] = arr[1]-1;
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}