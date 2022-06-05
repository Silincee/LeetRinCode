//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 387 👎 0


package leetcode.editor.cn;

//从中序与后序遍历序列构造二叉树

import leetcode.editor.cn.domain.TreeNode;

public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
			return build(inorder,0,inorder.length-1,
					postorder,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd){
    	// 递归出口
		if (inStart>inEnd) return null;

    	// 找到根节点
		int rootVal = postorder[postEnd]; // 别用postorder.length-1 太浪费时间
		int index = -1;
		for (int i = inStart; i <=inEnd; i++) {
			if (inorder[i]==rootVal) {
				index = i;
				break;
			}
		}
		// 迭代生成左右子树
		TreeNode root = new TreeNode(rootVal);
		int leftSize = index-inStart; // 左子树节点个数

		root.left = build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
		root.right = build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);

		return root;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}