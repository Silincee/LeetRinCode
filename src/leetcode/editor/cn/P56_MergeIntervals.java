//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 859 👎 0


package leetcode.editor.cn;

//合并区间

import java.util.Arrays;

public class P56_MergeIntervals{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P56_MergeIntervals().new Solution();
	 	 int[][] intervals = new int[4][2];
	 	 intervals[0] = new int[]{1,3};
	 	 intervals[1] = new int[]{2,6};
	 	 intervals[2] = new int[]{8,10};
	 	 intervals[3] = new int[]{15,18};
	 	 solution.merge(intervals);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
		// 遍历区间
		int[][] res = new int[intervals.length][2];
		int index = -1;
		for (int[] interval: intervals) {
			// 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
			// 则不合并，直接将当前区间加入结果数组
			if (index == -1 || interval[0] > res[index][1]) {
				index++;
				res[index] = interval;
			} else {
				// 反之将当前区间合并至结果数组的最后区间
				res[index][1] = Math.max(res[index][1], interval[1]);
			}
		}
		return Arrays.copyOf(res, index + 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}