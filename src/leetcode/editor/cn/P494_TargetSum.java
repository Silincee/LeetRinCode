//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 488 👎 0


package leetcode.editor.cn;

//目标和

public class P494_TargetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P494_TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            // 这两种情况，不可能存在合法的子集划分
            if (sum < target || (sum + target) % 2 == 1) {
                return 0;
            }
            return subsets(nums, (sum + target) / 2);
        }

        int subsets(int[] nums, int sum) {
            int n = nums.length;
            int[] dp = new int[sum + 1];
            // base case
            dp[0] = 1;


            for (int i = 0; i < n; i++) {
                for (int j = sum; j >= nums[i]; j--) {
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
            return dp[sum];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}