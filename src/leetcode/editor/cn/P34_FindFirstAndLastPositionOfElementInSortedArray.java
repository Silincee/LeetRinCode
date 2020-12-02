//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 670 👎 0


package leetcode.editor.cn;

//在排序数组中查找元素的第一个和最后一个位置

public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] ints = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(ints[0] + "\t" + ints[1]);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

			// 寻找左边界
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                }
            }
            // 越界或不存在补丁
            int res1 = left;
            if (left >= nums.length || nums[left] != target) {
                res1 = -1;
            }

			// 寻找右边界
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                }
            }
            // 越界或不存在补丁
            int res2 = right;
            if (right < 0 || nums[right] != target) {
                res2 = -1;
            }

            return new int[]{res1, res2};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}