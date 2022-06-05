//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 894 👎 0


package leetcode.editor.cn;

//零钱兑换

public class P322_CoinChange {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P322_CoinChange().new Solution();
        int i = solution.coinChange(new int[]{1}, 2);
        System.out.println(i);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int coinChange(int[] coins, int amount) {

            // dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
            int[] dp = new int[amount + 1];
            // 考虑到递推公式的特性，dp[j]必须初始化为一个最大的数，否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中被初始值覆盖。
            for (int j = 0; j <= amount; j++) {
                dp[j] = Integer.MAX_VALUE;
            }

            // base case：首先凑足总金额为0所需钱币的个数一定是0，那么dp[0] = 0
            dp[0] = 0;

            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j- coins[i]]  + 1);
                    }
                }

            }
			return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}