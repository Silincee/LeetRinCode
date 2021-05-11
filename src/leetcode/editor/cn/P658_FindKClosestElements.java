//给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 104 
// 数组里的每个元素与 x 的绝对值不超过 104 
// 
// Related Topics 二分查找 
// 👍 199 👎 0


package leetcode.editor.cn;

//找到 K 个最接近的元素

import java.util.ArrayList;
import java.util.List;

public class P658_FindKClosestElements{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P658_FindKClosestElements().new Solution();
	 	 solution.findClosestElements(new int[]{1,2,3,4,5},4,3);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
		ArrayList<Integer> res = new ArrayList<>();

		// 二分找到 >=x 的下界
		int left = -1;
		int right = arr.length;
		while (left+1!=right){
			int m = (right-left)/2+left;
			if (arr[m]<x){
				left = m;
			}else {
				right = m;
			}
		}

		left = right-1;

		while (res.size()!=k){
			if (right==arr.length||left>=0&&Math.abs(x-arr[left])<=Math.abs(arr[right]-x)){
				res.add(0,arr[left]);
				left--;
			}else if (right<arr.length){
				res.add(arr[right]);
				right++;
			}
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}