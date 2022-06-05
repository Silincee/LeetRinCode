//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 521 👎 0


package leetcode.editor.cn;

//二叉树的右视图

import leetcode.editor.cn.BinaryTree.BinaryTreeUtils;
import leetcode.editor.cn.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P199_BinaryTreeRightSideView{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P199_BinaryTreeRightSideView().new Solution();
		 TreeNode root = BinaryTreeUtils.createBT("1,2,3,#,5,#,4");
		 solution.rightSideView(root);
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
    public List<Integer> rightSideView(TreeNode root) {
		if(root==null) {
			return new ArrayList<>();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> res = new ArrayList<>();

		queue.offer(root);
		res.add(root.val);

		while(!queue.isEmpty()){

			TreeNode node = queue.poll();
			if(node.right!=null){
				queue.offer(node.right);
				res.add(node.right.val);
			}else if (node.left!=null){
				queue.offer(node.left);
				res.add(node.left.val);
			}

		}
		

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}