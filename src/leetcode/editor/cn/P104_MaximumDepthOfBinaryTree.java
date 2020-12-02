//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 707 👎 0


package leetcode.editor.cn;

//二叉树的最大深度


import leetcode.editor.cn.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root==null ) return 0;
            // 队列里存放的是「当前层的所有节点」
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            /**
             * add是list的
             * offer是queue的
             * api里说：
             * add：Inserts the specified element at the specified position in this list
             * 将指定的元素插入到list中指定的的位置。
             * offer：
             * 如果在不违反容量限制的情况下，尽可能快的将指定的元素插入到queue中去
             * */
            queue.offer(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                // 每层节点的数量
                int size = queue.size();
                // 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展
                for (int i = 0; i < size; i++) {
                    // poll() 检索并删除此列表的头部（第一个元素）。
                    TreeNode node = queue.poll();
                    if (node.left!=null) queue.offer(node.left);
                    if (node.right!=null) queue.offer(node.right);
                }
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}