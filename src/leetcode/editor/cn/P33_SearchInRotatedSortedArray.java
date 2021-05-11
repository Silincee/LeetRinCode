//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1331 👎 0


package leetcode.editor.cn;

//搜索旋转排序数组

public class P33_SearchInRotatedSortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P33_SearchInRotatedSortedArray().new Solution();
		 System.out.println(solution.search(new int[]{1,3}, 3));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
		int index = findMin(nums); // 旋转点
		int left = 0;
		int right = 0;

		// 根据 nums[0] 与 target 的关系判断 target 在左段还是右段，再对升序数组进行二分查找即可。
		// [4,5,6,7,0,1,2]
		if (target>=nums[0]){
			// target 在左段
			left = -1;
			right = index;
		}else {
			// target 在右段
			if (index==nums.length){
				left = -1;
			}else {
				left = index-1;
			}

			right = nums.length;
		}

		// 二分查找target，无重复元素
		while (left+1!=right){
			int m = (right-left)/2+left;
			if (nums[m]<=target){
				left= m;
			}else {
				right = m;
			}
		}

		if (left==-1||nums[left]!=target){
			left=-1;
		}

		return left;

	}

	// 返回旋转数组的最小值下标
	public int findMin(int[] nums) {
		int left = -1;
		int right = nums.length;

		while (left+1!=right){
			int m = (right-left)/2+left;

			if (nums[m]>=nums[0]){ // 记得有=号，特殊case[2,1]
				left = m;
			}else {
				right = m;
			}
		}

		if (right==nums.length) return right; // 旋转了一圈回来了,如[1,2,3,4]

		return right;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}