//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 90 👎 0


package leetcode.editor.cn;

//0～n-1中缺失的数字

public class QueShiDeShuZiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new QueShiDeShuZiLcof().new Solution();
	 }
//力扣代码 https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while (left<=right){
			int m = (right-left)/2+left;
			if (nums[m]==m) {
				left=m+1;
			}else {
				right=m-1;
			}
		}
		return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}