//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2571 👎 0


package leetcode.editor.cn;

//整数反转

import java.util.ArrayList;
import java.util.HashMap;

public class P7_ReverseInteger{
	 public static void main(String[] args) {
	 	 //测试代码

	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
 class Solution {
    public int reverse(int x) {
		// int 的范围 -2147483648 - 2147483647 ， 所以判断7和-8
		// x = 321
		int ans = 0;
		while (x!=0){
			int pop = x%10;
			x = x/10;
			// 正树时候
			if (ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&pop>7)) return 0;
			// -
			if (ans<Integer.MIN_VALUE/10||(ans==Integer.MIN_VALUE/10&&pop<-8)) return 0;
			ans = ans*10+pop;
		}

		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}