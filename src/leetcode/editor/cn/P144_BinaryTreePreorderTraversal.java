//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 548 👎 0


package leetcode.editor.cn;

//二叉树的前序遍历

import leetcode.editor.cn.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144_BinaryTreePreorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P144_BinaryTreePreorderTraversal().new Solution();
		 TreeNode node1 = new TreeNode(1);
		 TreeNode node4 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(2);
		 TreeNode node3 = new TreeNode(3);
		 node1.left = node4;
		 node1.right = node2;
		 node2.left = node3;
		 solution.preorderTraversal(node1);
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
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root==null) return list;

		while (root!=null||!stack.isEmpty()){
			if (root!=null){
				// 根 左 右
				list.add(root.val);
				stack.push(root);
				root = root.left;
			}else {
				TreeNode temp = stack.pop();
				root = temp.right;
			}
		}
		return list;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}