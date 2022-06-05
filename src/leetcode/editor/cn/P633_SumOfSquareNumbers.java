//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。 
//
// 示例1: 
//
// 
//输入: 5
//输出: True
//解释: 1 * 1 + 2 * 2 = 5
// 
//
// 
//
// 示例2: 
//
// 
//输入: 3
//输出: False
// 
// Related Topics 数学 
// 👍 137 👎 0


package leetcode.editor.cn;

//平方数之和

public class P633_SumOfSquareNumbers{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P633_SumOfSquareNumbers().new Solution();
		 System.out.println(solution.judgeSquareSum(5));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
    	int left = 0;
    	int right = (int)Math.sqrt(c);

    	while(left<=right){
    		while (left*left==(c-right*right)) return true;
    		while (left*left>(c-right*right))right--;
    		while (left*left<(c-right*right))left++;
		}
    	return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}