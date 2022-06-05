//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
//  [20,9],
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
// Related Topics 树 广度优先搜索 
// 👍 67 👎 0


package leetcode.editor.cn;

//从上到下打印二叉树 III

import leetcode.editor.cn.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
		TreeNode root = new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		List<List<Integer>> lists = solution.levelOrder(root);
		System.out.println(lists);
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();

            LinkedList<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();

            queue.offer(root);

           while (!queue.isEmpty()){ // 当 deque 为空时跳出；
			   LinkedList<Integer> temp = new LinkedList<>();
			   // 当前层打印循环： 循环次数为当前层节点数（即 deque 长度）;
			   // 为什么用--的方式，因为i只会赋值一次；如果写在判断上的话，由于队列长度一直在变，导致循环次数不确定
			   for(int i = queue.size(); i > 0; i--) {
				   TreeNode node = queue.poll();
				   System.out.println(i);

				   if (res.size()%2==0) temp.addLast(node.val);
				   else temp.addFirst(node.val);

				   if (node.left!=null) queue.add(node.left);
				   if (node.right!=null) queue.add(node.right);
			   }
			   res.add(temp);
		   }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}