//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 83 👎 0


package leetcode.editor.cn;

//在排序数组中查找数字 I

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
	 	 solution.search(new int[]{5,7,7,8,8,10},8);
	 }
//力扣代码 https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
		int left = left_bound(nums,target);
		int right = right_bound(nums,target);

		if (left==-1) return 0;
    	return  right-left+1;
    }
	int right_bound(int[] nums, int target) {

		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				// 这里改成收缩左侧边界即可
				left = mid + 1;
			}
		}
		// 这里改为检查 right 越界的情况，见下图
		if (right < 0 || nums[right] != target)
			return -1;
		return right;
	}

	int left_bound(int[] nums, int target) {

		int left = 0, right = nums.length - 1;
		// 搜索区间为 [left, right]
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				// 搜索区间变为 [mid+1, right]
				left = mid + 1;
			} else if (nums[mid] > target) {
				// 搜索区间变为 [left, mid-1]
				right = mid - 1;
			} else if (nums[mid] == target) {
				// 收缩右侧边界
				right = mid - 1;
			}
		}
		// 检查出界情况
		if (left >= nums.length || nums[left] != target)
			return -1;
		return left;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}