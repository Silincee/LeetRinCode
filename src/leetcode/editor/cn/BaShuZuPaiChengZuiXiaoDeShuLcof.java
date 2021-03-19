//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 145 👎 0


package leetcode.editor.cn;

//把数组排成最小的数

import java.util.Arrays;

public class BaShuZuPaiChengZuiXiaoDeShuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public String minNumber(int[] nums) {
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}

//		fastSort(strings,0,nums.length-1); // 快速排序
		Arrays.sort(strings,(x,y)->(x+y).compareTo(y+x));// 内置排序函数

		StringBuilder builder = new StringBuilder();
		for (String string : strings) {
			builder.append(string);
		}

		return builder.toString();

	}


	void fastSort(String[] strs, int l, int r) {
		if(l >= r) return;
		int i = l, j = r;
		String tmp = strs[i];
		while(i < j) {
			// 与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止，返回该不同的字符的asc码差值，
			while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
			while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
			tmp = strs[i];
			strs[i] = strs[j];
			strs[j] = tmp;
		}
		strs[i] = strs[l];
		strs[l] = tmp;
		fastSort(strs, l, i - 1);
		fastSort(strs, i + 1, r);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}