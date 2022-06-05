//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 510 👎 0


package leetcode.editor.cn;

//二叉树的直径

import leetcode.editor.cn.domain.TreeNode;

public class P543_DiameterOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P543_DiameterOfBinaryTree().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	int ans = 0;
	// 返回直径5(两结点之间的路径长度是以它们之间边的数目表示),也可以理解为2(左子树深度) +3(右子树深度)。
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return ans;
	}
	// 获取二叉树的高度
	public int depth(TreeNode node){
		if (node==null) return 0;
		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);
		ans = Math.max(leftDepth+rightDepth,ans);
		return Math.max(leftDepth,rightDepth)+1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
//           1     3
//         / \
//        2   3   2   1
//       / \
//      4   5   1  1