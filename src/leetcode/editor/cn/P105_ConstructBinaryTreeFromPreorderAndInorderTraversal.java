//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
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
// Related Topics 树 深度优先搜索 数组 
// 👍 722 👎 0


package leetcode.editor.cn;

//从前序与中序遍历序列构造二叉树

import leetcode.editor.cn.domain.TreeNode;

public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
		// 迭代构造二叉树
		return build(preorder,0,preorder.length-1,
				inorder,0,inorder.length-1);
    }


   // 若前序遍历数组为 preorder[preStart..preEnd]， [3, 9,20,15,7]
   // 中续遍历数组为 inorder[inStart..inEnd]，      [9, 3, 15,20,7]
   // 构造二叉树，返回该二叉树的根节点
    public TreeNode build(int[] preorder,int preLow,int preHigh,int[] inorder,int inLow,int inHigh){
    	// 终止条件
    	if (preHigh<preLow){ return null;}
    	// 先找第一层的节点，再把前序遍历分出左右子树
		int rootVal = preorder[preLow];
		int rootIndex = -1;
		for (int i = inLow; i <=inHigh ; i++) {
			if (inorder[i]==rootVal){
				rootIndex=i;
				break;
			}
		}

		int leftLength = rootIndex-inLow;

		TreeNode root = new TreeNode(rootVal);
		root.left = build(preorder,preLow+1,preLow+leftLength,inorder,inLow,rootIndex-1);
		root.right = build(preorder,preLow+leftLength+1,preHigh,inorder,rootIndex+1,inHigh);

		return root;

	}

}
//leetcode submit region end(Prohibit modification and deletion)

}