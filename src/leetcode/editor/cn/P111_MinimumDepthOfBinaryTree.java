//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 406 👎 0


package leetcode.editor.cn;

//二叉树的最小深度

import leetcode.editor.cn.utils.TreeNode;

import java.util.LinkedList;

public class P111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // root 本身就是一层，depth 初始化为1
            int depth = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                // 将当前队列中的所有节点向四周扩散
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    // 判断是否达到终点
                    if (cur.left == null && cur.right == null) return depth;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                // 增加步数
                depth++;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}