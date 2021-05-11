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
//        int[] ints = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        int[] ints = solution.searchRange(new int[]{2,4}, 3);
        System.out.println(ints[0] + "\t" + ints[1]);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[2];

            // 找上界
            int left = -1;
            int right = nums.length;

            while (left + 1 != right) {
                int m = (left + right) / 2;
                if (nums[m]<target){
                    left = m;
                }else {
                    right=m;
                }
            }
            if (right==nums.length||nums[right]!=target){
                res[0] = -1;
            }else {
                res[0] = right;
            }


            // 找下界
             left = -1;
             right = nums.length;

            while (left + 1 != right) {
                int m = (left + right) / 2;
                if (nums[m]<=target){
                    left = m;
                }else {
                    right=m;
                }
            }

            if (left==-1||nums[left]!=target){
                res[1] = -1;
            }else {
                res[1] = left;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}