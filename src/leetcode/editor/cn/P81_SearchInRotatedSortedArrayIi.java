//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums
//[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,
//2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 targ
//et ，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,5,6,0,0,1,2], target = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -104 <= target <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 421 👎 0


package leetcode.editor.cn;

//搜索旋转排序数组 II

public class P81_SearchInRotatedSortedArrayIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P81_SearchInRotatedSortedArrayIi().new Solution();
		 System.out.println(solution.search(new int[]{1,1}, 1));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean search(int[] nums, int target) {
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
			return false;
		}

		return true;

	}

	// 返回旋转数组的最小值下标
	public int findMin(int[] nums) {


		int left = -1;
		int right = nums.length;

		// 预处理恢复二段性
		while (right>1&&nums[0]==nums[right-1]) right--;


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