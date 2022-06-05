//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 121 👎 0


package leetcode.editor.cn;

//二叉树中和为某一值的路径

import leetcode.editor.cn.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
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
	public List<List<Integer>> res = new ArrayList<>();
	LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		recur(root,sum);
		return res;
    }

	private void recur(TreeNode root, int sum) {
		if (root==null) return;

		/*******先序遍历框架******/
		path.add(root.val);
		int tar = sum-root.val;
		// ⚠️ 值得注意的是，记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res
		// 后续 path 改变时， res 中的 path 对象也会随之改变。
		// 正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。
		if (tar==0&& root.left == null && root.right == null) res.add(new LinkedList<>(path));

		recur(root.left,tar);
		recur(root.right,tar);

		path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}