//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 185 👎 0


package leetcode.editor.cn;

//连续子数组的最大和

public class LianXuZiShuZuDeZuiDaHeLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) { // [-2,1,-3,4,-1,2,1,-5,4]
    	int n = nums.length;
    	if (n==0) return 0;

    	// 以 nums[i] 为结尾的「最大子数组和」为 dp[i]。
    	int[] dp = new int[nums.length];

    	// base case
		dp[0] = nums[0];
		int res = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
			res = Math.max(res, dp[i]);
		}
		return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}