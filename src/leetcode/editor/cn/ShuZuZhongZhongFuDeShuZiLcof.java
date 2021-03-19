//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 236 👎 0


package leetcode.editor.cn;

//数组中重复的数字

import java.util.HashMap;
import java.util.HashSet;

public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        solution.findRepeatNumber(new int[]{1, 2, 3, 2});
    }

    //力扣代码 https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
    * @description: 2021-02-03 ok
    */ 
    class Solution {
    	/**
    	 * @description: 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，
		 * 遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。
		 * 在交换过程中，如果有重复的数字发生，那么终止返回ture
    	*/

        public int findRepeatNumber(int[] nums) {
            int temp;
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i) {
                    if (nums[i] == nums[nums[i]]) { // 发现你i号坑也是i号萝卜，那我还换个锤子，同时也说明有重复元素出现。
                        return nums[i];
                    }
                    // 遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。
					// 即交换nums[i] 和 nums[temp]
                    temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
            return -1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}