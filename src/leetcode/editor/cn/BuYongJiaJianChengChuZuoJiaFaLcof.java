//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 108 👎 0


package leetcode.editor.cn;

//不用加减乘除做加法

public class BuYongJiaJianChengChuZuoJiaFaLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
	 }
//力扣代码 https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) { // a-00010100 b-00010001
		// a + b = 无进位和n +  进位c
		while (b!=0){
			int n = a^b;
			int c = (a&b)<<1;
			a = n;
			b=c;
		}
		return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}