//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 164 👎 0


package leetcode.editor.cn;

//滑动窗口的最大值

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class HuaDongChuangKouDeZuiDaZhiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
	 	 solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) { // [1,3,-1,-3] , 3

		if(nums.length == 0 || k == 0) return new int[0];

		// 双端队列 deque ，结果列表 res ，数组长度 n ；
		Deque<Integer> deque = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];

		// 滑动窗口： 左边界i范围: [1 - k, n - k]，右边界j范围: [0, n - 1]
		for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
			// 若 i > 0 且 队首元素 deque[0] == 被删除元素 nums[i−1] ：则队首元素出队
			if(i > 0 && deque.peekFirst() == nums[i - 1])
				deque.removeFirst();

			// 删除 deque 内所有 <nums[j] 的元素，以保持 deque 递减；
			while(!deque.isEmpty() && deque.peekLast() < nums[j])
				deque.removeLast();

			// 将 nums[j] 添加至 deque 尾部；
			deque.addLast(nums[j]);

			// 若已形成窗口（即 i≥0 ）：将窗口最大值（即队首元素 deque[0] ）添加至列表 res 。
			if(i >= 0)
				res[i] = deque.peekFirst();
		}

		return res;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}