//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 933 👎 0


package leetcode.editor.cn;

//分割等和子集

import java.util.Arrays;

public class P416_PartitionEqualSubsetSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
	 	 boolean[] nums = new boolean[2];
		 System.out.println();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean canPartition(int[] nums) {
		int sum = Arrays.stream(nums).sum();
		if(sum%2==1) {
			return false;
		}
		return dp(nums,sum/2);
	}

	// weight:nums bagWeight:target
	boolean dp(int[] nums,int target){
		// 初始化
		int n = nums.length;
		boolean[] dp = new boolean[target+1];
		dp[0]=true;

		// dp公式 dp[j] = dp[j] + dp[j-nums[i]];
		// 0-1问题，先遍历物品再遍历背包,倒序且>nums[i]
		for(int i=0;i<nums.length;i++){
			for(int j=target;j>=nums[i];j--){
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}

		return dp[target];

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}