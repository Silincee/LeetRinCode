//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix =
// [[1,2,3],
// [4,5,6],
// [7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 168 👎 0


package leetcode.editor.cn;

//顺时针打印矩阵

public class ShunShiZhenDaYinJuZhenLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
	 	 solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	 }
//力扣代码 https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution { // 😭
    public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0) return new int[0]; //空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。

		// 初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
		int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
		int[] res = new int[(r + 1) * (b + 1)];

		//循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
		//1. 根据边界打印，即将元素按顺序添加至列表 res 尾部；
		//2. 边界向内收缩 11 （代表已被打印）；
		//3. 判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
		while(true) {
			for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
			if(++t > b) break;

			for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
			if(l > --r) break;

			for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
			if(t > --b) break;

			for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
			if(++l > r) break;
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}