//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学 
// 👍 69 👎 0


package leetcode.editor.cn;

//打印从1到最大的n位数

public class DaYinCong1daoZuiDaDeNweiShuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
		 System.out.println(solution.printNumbers(3));
	 }
//力扣代码 https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	StringBuilder res;
	int count = 0, n;
	char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	int start; int nine=0; // 用于删除多余的0

	public String printNumbers(int n) {
		this.n = n;
		res = new StringBuilder(); // 数字字符串集
		num = new char[n]; // 定义长度为 n 的字符列表
		start=n-1;
		dfs(0); // 开启全排列递归
		res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
		return res.toString(); // 转化为字符串并返回
	}

	void dfs(int x) {
		if(x == n) { // 终止条件：已固定完所有位
			String s = String.valueOf(num).substring(start); // 截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
			if (!s.equals("0")) res.append(s+",");
			if (n-start==nine) start--; // 所有位都为 99 的判断条件可用以下公式表示：n - start = nine
			return;
		}
		// 从最高位开始固定
		for(char i : loop) { // 遍历 ‘0‘ - ’9‘
			if (i=='9') nine++;
			num[x] = i; // 固定第 x 位为 i
			dfs(x + 1); // 开启固定第 x + 1 位
		}
		nine--;
	}
}

//leetcode submit region end(Prohibit modification and deletion)

}