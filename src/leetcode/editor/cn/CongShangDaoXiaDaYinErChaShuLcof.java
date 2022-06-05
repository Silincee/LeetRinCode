//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 56 👎 0


package leetcode.editor.cn;

//从上到下打印二叉树

import leetcode.editor.cn.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class CongShangDaoXiaDaYinErChaShuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
		 TreeNode root = new TreeNode(3);
		 root.left=new TreeNode(9);
		 root.right=new TreeNode(20);
		 root.right.left=new TreeNode(15);
		 root.right.right=new TreeNode(7);
		 solution.levelOrder(root);
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
    public int[] levelOrder(TreeNode root) {
		if (root==null) return new int[]{};

		// bfs
		LinkedList<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> res = new ArrayList<>();

		queue.offer(root);

		while (queue.size()>0){
			TreeNode node = queue.poll();
			res.add(node.val);
			if (node.left!=null) queue.offer(node.left);
			if (node.right!=null) queue.offer(node.right);
		}
		int[] res1 = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			res1[i] = res.get(i);
		}

		return res1;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}