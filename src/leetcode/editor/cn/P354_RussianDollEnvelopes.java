//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 242 👎 0


package leetcode.editor.cn;

//俄罗斯套娃信封问题

import java.util.Arrays;
import java.util.Comparator;

public class P354_RussianDollEnvelopes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P354_RussianDollEnvelopes().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		// [5,4],[6,4],[6,7],[2,3] --> [2,3],[5,4],[6,4],[6,7]
		Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]); // w相等则比较h(h小在后)，不想等直接比较w(w小在前)

		// 对高度数组寻找 LIS
		int[] height = new int[n];
		for (int i = 0; i < n; i++)
			height[i] = envelopes[i][1];

		return lengthOfLIS(height);
    }

	public int lengthOfLIS(int[] height) {
		int[] dp = new int[height.length];
		Arrays.fill(dp, 1);
		for (int i = 0; i < height.length; i++) {
			for (int j = 0; j < i; j++) {
				if (height[j]<height[i]) {
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res,dp[i]);
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}