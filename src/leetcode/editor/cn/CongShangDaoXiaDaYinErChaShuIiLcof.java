//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 73 👎 0


package leetcode.editor.cn;

//从上到下打印二叉树 II

import leetcode.editor.cn.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
	 }
//力扣代码 https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/solution/mian-shi-ti-32-ii-cong-shang-dao-xia-da-yin-er-c-5/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();

		if (root!=null) queue.offer(root);

		while(!queue.isEmpty()){
			ArrayList<Integer> temp = new ArrayList<>();

			for (int i = queue.size(); i >0 ; i--) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left!=null) queue.offer(node.left);
				if (node.right!=null) queue.offer(node.right);
			}
			res.add(temp);
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}