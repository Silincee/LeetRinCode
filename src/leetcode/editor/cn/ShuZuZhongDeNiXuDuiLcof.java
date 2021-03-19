//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 305 👎 0


package leetcode.editor.cn;

//数组中的逆序对

import java.util.Arrays;

public class ShuZuZhongDeNiXuDuiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
	 }
//力扣代码 undo
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int reversePairs(int[] nums) {
		int n = nums.length;
		int[] tmp = new int[n];
		System.arraycopy(nums, 0, tmp, 0, n);
		// 离散化
		Arrays.sort(tmp);
		for (int i = 0; i < n; ++i) {
			nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
		}
		// 树状数组统计逆序对
		BIT bit = new BIT(n);
		int ans = 0;
		for (int i = n - 1; i >= 0; --i) {
			ans += bit.query(nums[i] - 1);
			bit.update(nums[i]);
		}
		return ans;
	}
}

	class BIT {
		private int[] tree;
		private int n;

		public BIT(int n) {
			this.n = n;
			this.tree = new int[n + 1];
		}

		public  int lowbit(int x) {
			return x & (-x);
		}

		public int query(int x) {
			int ret = 0;
			while (x != 0) {
				ret += tree[x];
				x -= lowbit(x);
			}
			return ret;
		}

		public void update(int x) {
			while (x <= n) {
				++tree[x];
				x += lowbit(x);
			}
		}

}
//leetcode submit region end(Prohibit modification and deletion)

}