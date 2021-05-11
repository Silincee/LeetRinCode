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
        public int result = 0; // 方法数

        public int findTargetSumWays(int[] nums, int S) {
            backtrack(nums, S, 0);
            return result;
        }

        /**
         * @description: target 目标值，为0则方法数+1； index当前处于的数组位置，用于充当可选列表
         */
        private void backtrack(int[] nums, int target, int index) {

            if (index == nums.length) {
                if (target == 0) {
                    result++;
                }
                return;
            }


                target = target - nums[index];
                backtrack(nums, target, index+1);
                target = target + nums[index];

                target = target + nums[index];
                backtrack(nums, target, index+1);
                target = target - nums[index];


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}