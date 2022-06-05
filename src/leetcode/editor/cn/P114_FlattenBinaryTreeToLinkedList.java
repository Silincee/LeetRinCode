//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 606 👎 0


package leetcode.editor.cn;

//二叉树展开为链表

import leetcode.editor.cn.domain.TreeNode;

public class P114_FlattenBinaryTreeToLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P114_FlattenBinaryTreeToLinkedList().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
    	// 后序遍历
		if(root==null) return;

		flatten(root.left);
		flatten(root.right);

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.right = left;
		// 置空左子树
		root.left = null;

		// 先用左子树替换右子树
		// 把右子树接到当前右子树的底部
		while(root.right!=null){
			root = root.right;
		}
		root.right = right;





    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


