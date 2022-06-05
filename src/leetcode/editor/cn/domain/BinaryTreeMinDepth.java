package leetcode.editor.cn.domain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 二叉树的最小深度
 * @author: Silince
 * @create: 2021-03-16 12:42
 **/
public class BinaryTreeMinDepth {

    /**
    * @description: 广度优先
    */
    static int minDepth(TreeNode root){
         if (root==null) return 0;
         Queue<TreeNode> queue = new LinkedList<>();
         int ans = 0;
         queue.offer(root);
         while (!queue.isEmpty()){
             ans++;
             int size = queue.size();
             for (int i = 0; i < size; i++) {
                 TreeNode node = queue.poll();
                 if (node.left==null&&node.right==null) return ans;

                 if (node.left!=null) queue.offer(node.left);
                 if (node.right!=null) queue.offer(node.right);
             }
         }
         return -1;
     }

     /**
     * @description: 递归
     */
     static int minDepth2(TreeNode root){ // 返回当前节点的最小深度
         if (root==null) return 0;

         if (root.left==null) return minDepth2(root.right)+1;
         if (root.right==null) return minDepth2(root.left)+1;

        return Math.min(minDepth2(root.left),minDepth2(root.right)+1);
     }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        root.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        int i = BinaryTreeMinDepth.minDepth2(root);
        System.out.println(i);
    }
}
