//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 467 👎 0


package leetcode.editor.cn;

//两个数组的交集 II

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P350_IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P350_IntersectionOfTwoArraysIi().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int index = 0, index1 = 0, index2 = 0;
            int len1 = nums1.length, len2 = nums2.length;
            int[] res = new int[len1 + len2];

            while (index1 < len1 && index2 < len2) {
                if (nums1[index1] == nums2[index2]) {
                    res[index] = nums1[index1];
                    index++;
                    index1++;
                    index2++;
                } else if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return Arrays.copyOf(res, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}