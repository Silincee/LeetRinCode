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
    	// 负数 return false
		if (c<0) return false;
		// 定义两个指针a,b 0 和 sqrt(c) 逼近
		int a = 0;
		int b = (int) Math.sqrt(c);
		// 逼近 直到a=b
		while(a<=b) {
			// aa+bb<c  a++
			long sum = a*a+b*b;
			if (sum==c) return true;
			// aa+bb>c b--
			else if (sum<c){a++;}else {b--;}
		}
    	return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}