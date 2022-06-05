//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limi
//t 。 
//
// 如果不存在满足条件的子数组，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,2,4,7], limit = 4
//输出：2 
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4. 
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4. 
//因此，满足题意的最长子数组的长度为 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4 
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
// 
//
// 示例 3： 
//
// 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 数组 Sliding Window 
// 👍 173 👎 0


package leetcode.editor.cn;

//绝对差不超过限制的最长连续子数组

import java.util.Deque;
import java.util.LinkedList;

public class P1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
	 	 // [10,1,2,4,7,2], limit = 5
		 solution.longestSubarray(new int[]{10,1,2,4,7,2},5);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 输入：nums = [8,2,4,7], limit = 4
	//输出：2
    public int longestSubarray(int[] nums, int limit) {
		int left = 0;
		int right = 0;
		int res = 0;
		Deque<Integer> maxQueue = new LinkedList<>();
		Deque<Integer> minQueue = new LinkedList<>();

		while (right < nums.length) {
			while (!maxQueue.isEmpty() && nums[right] > maxQueue.peekLast())
				maxQueue.removeLast();
			while (!minQueue.isEmpty() && nums[right] < minQueue.peekLast())
				minQueue.removeLast();
			maxQueue.add(nums[right]);
			minQueue.add(nums[right]);
			right++;

			while (maxQueue.peek() - minQueue.peek() > limit) {
				if (maxQueue.peek() == nums[left]) maxQueue.remove();
				if (minQueue.peek() == nums[left]) minQueue.remove();
				left++;
			}
			res = Math.max(res, right - left);
		}
		return res;


		}

}
//leetcode submit region end(Prohibit modification and deletion)

}