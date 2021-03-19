//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 108 👎 0


package leetcode.editor.cn;

//数值的整数次方

public class ShuZhiDeZhengShuCiFangLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
	 }
//力扣代码 https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
		if(x == 0) return 0; // 当 x = 0 时：直接返回 0 （避免后续 x = 1/x 操作报错）
		long b = n;
		double res = 1.0; // 初始化 res=1

		// 当 n <0 时：把问题转化至 n≥0 的范围内，即执行 x=1/x ，n=−n ；
		// Java 代码中 int32 变量 n∈[−2147483648,2147483647] ，
		// 因此当n=−2147483648 时执行 n=−n 会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
		if(b < 0) {
			x = 1 / x;
			b = -b;
		}
		// 循环计算：当 n=0 时跳出
		while(b > 0) {
			if((b & 1) == 1) res *= x;
			x *= x;
			b >>= 1;
		}
		return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}