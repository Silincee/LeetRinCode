//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 
// 👍 87 👎 0


package leetcode.editor.cn;

//二叉树的镜像

import leetcode.editor.cn.utils.TreeNode;

public class ErChaShuDeJingXiangLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
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
    public TreeNode mirrorTree(TreeNode root) {
		if (root==null) return null;

		/**** 前序遍历位置 ****/
		// root 节点需要交换它的左右子节点
		TreeNode temp = root.left;
		root.left=root.right;
		root.right=temp;

		// 让左右子节点继续翻转它们的子节点
		mirrorTree(root.left);
		mirrorTree(root.right);

		return root;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}