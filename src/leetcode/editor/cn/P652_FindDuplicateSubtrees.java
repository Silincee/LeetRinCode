//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 167 👎 0


package leetcode.editor.cn;

//寻找重复的子树

import leetcode.editor.cn.utils.TreeFactory;
import leetcode.editor.cn.utils.TreeNode;
import leetcode.editor.cn.utils.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class P652_FindDuplicateSubtrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P652_FindDuplicateSubtrees().new Solution();
        TreeNode myBinaryTree = TreeFactory.creatTree();
//		 TreeUtils.preTraverse(myBinaryTree);
        List<TreeNode> duplicateSubtrees = solution.findDuplicateSubtrees(myBinaryTree);
		System.out.println("--------");
        for (TreeNode duplicateSubtree : duplicateSubtrees) {
            System.out.println(duplicateSubtree.val);
        }
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

        // 记录所有子树以及出现的次数
        HashMap<String, Integer> memo = new HashMap<>();
        // 记录重复的子树根节点
        LinkedList<TreeNode> res = new LinkedList<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);
            return res;
        }

        /* 辅助函数 */
        public String traverse(TreeNode root) {
            // 对于空节点，可以用一个特殊字符表示
            if (root == null) return "#";
            // 将左右子树序列化成字符串
            String left = traverse(root.left);
            String right = traverse(root.right);
            /* 后序遍历代码位置 */
            // 左右子树加上自己，就是以自己为根的二叉树序列化结果
            String subTree = left + "," + right + "," + root.val; // 描述以该节点为根的二叉树。
            System.out.println(subTree);

            int freq = memo.getOrDefault(subTree, 0);
            // 多次重复也只会被加入结果集一次
            if (freq == 1) res.add(root);

            // 对子树对应的出现次数加1
            memo.put(subTree, freq + 1);
            return subTree;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}