//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 172 👎 0


package leetcode.editor.cn;

//最小的k个数

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
	 }
//力扣代码 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	public int[] getLeastNumbers(int[] arr, int k) {
		if (k == 0 || arr.length == 0) {
			return new int[0];
		}
		// 最后一个参数表示我们要找的是下标为k-1的数
		return quickSearch(arr, 0, arr.length - 1, k - 1);
	}

	private int[] quickSearch(int[] nums, int lo, int hi, int k) {
		// 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
		int j = partition(nums, lo, hi); // j 中枢点的索引
		if (j == k) {
			return Arrays.copyOf(nums, j + 1);
		}
		// 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
		return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
	}

	// 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
	private int partition(int[] arr, int start, int end) {
		int low = start;
		int high = end;
		int pivot = arr[low]; // 枢纽点pivot选取第一个元素
		while (low < high) {
			// high指针往左寻找一个小于 pivot的数
			while (low < high && arr[high] >= pivot) {
				high--;
			}
			arr[low] = arr[high]; // 将小于 pivot 的数放在低位

			// low指针往右寻找一个大于 pivot 的数
			while (low < high && arr[low] <= pivot) {
				low++;
			}
			arr[high] = arr[low]; // 将大于 pivot 的数放在高位
		}
		// 复原 pivot的值
		arr[low] = pivot;

		return low;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}