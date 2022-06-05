//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 500 👎 0


package leetcode.editor.cn;

//平衡二叉树

import leetcode.editor.cn.domain.TreeNode;

public class P110_BalancedBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P110_BalancedBinaryTree().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 对二叉树做先序遍历，从底至顶返回子树最大高度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回
	public boolean isBalanced(TreeNode root) {
		return recur(root) != -1;
	}

	private int recur(TreeNode root) {
		// 先序遍历 根-左-右
		if (root==null) return 0;
		int left = recur(root.left);
		if (left==-1) return -1;
		int right = recur(root.right);
		if (right==-1) return -1;
		return Math.abs(left-right)<=1?Math.max(left,right)+1:-1;
	}




	}

//leetcode submit region end(Prohibit modification and deletion)

}