//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 276 👎 0


package leetcode.editor.cn;

//重建二叉树

import leetcode.editor.cn.domain.TreeNode;

public class ZhongJianErChaShuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder,0,preorder.length-1,
				inorder,0,inorder.length-1);
	}

	// 若前序遍历数组为 preorder[preStart..preEnd]， [3, 9, 20,15,7]
	// 中序遍历数组为 inorder[inStart..inEnd]，      [9, 3, 15,20,7]
	// 构造二叉树，返回该二叉树的根节点
	public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){

		// 递归出口
		if (preStart>preEnd){
			return null;
		}

		// 根结点值
		int rootValue = preorder[preStart];

		// 在中序遍历数组中找到根结点索引
		int index = 0;
		for (int i = inStart; i <=inEnd ; i++) {
			if (rootValue==inorder[i]){
				index = i;
				break;
			}
		}

		TreeNode node = new TreeNode(rootValue);

		// 递归构造左右子树
		int leftCount = index-inStart;
		node.left=build(preorder,preStart+1,preStart+leftCount,inorder,inStart,index-1);
		node.right=build(preorder,preStart+leftCount+1,preEnd,inorder,index+1,inEnd);


		//返回根结点
		return node;

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}