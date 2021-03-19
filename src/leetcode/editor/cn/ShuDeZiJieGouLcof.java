//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 168 👎 0


package leetcode.editor.cn;

//树的子结构

import leetcode.editor.cn.utils.TreeNode;

public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
        	if (A==null||B==null) return false; // 特例处理： 当 树 A 为空 或 树 B 为空时，直接返回 false ；
            // 先序遍历A中的每个节点
            return (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }

        // 判断A中以n_a为根结点的子树是否包含树B
        public boolean recur(TreeNode A, TreeNode B) {
            // 终止条件
            // 1 节点B为空，说明树B已经完成匹配(越过叶子节点)，因此返回true
            // 2 节点A为空，说明已经越过A叶子节点，即匹配失败，返回false
            // 3 当节点A和B的值不同：说明匹配失效，返回false
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}