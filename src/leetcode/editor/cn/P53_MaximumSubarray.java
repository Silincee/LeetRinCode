//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2722 👎 0


package leetcode.editor.cn;

//最大子序和

public class P53_MaximumSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P53_MaximumSubarray().new Solution();
	 	 solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
    	int n = nums.length;
    	if (n==0) return 0;
		// [-2,1,-3,4,-1,2,1,-5,4]
		int[] dp = new int[n]; // 以nums[i]为结尾的最大值子数组和为dp[i]


		// 状态转移
		// base case
		dp[0]=nums[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
		}


		// 返回结果
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			res  = Math.max(res,dp[i]);
		}
		for (int i : dp) {
			System.out.print(i+"\t");
		}
		return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}