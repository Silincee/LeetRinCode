package leetcode.editor.cn.BinaryTree;

import leetcode.editor.cn.utils.TreeNode;

import java.util.List;

/**
 * @program: LeetCode
 * @description: 用数组来存储一棵二叉树，对这棵树按照完全二叉树的方式编号，其中结点不存在的使用特殊字符来标明。
 * @author: Silince
 * @create: 2020-10-13 19:32
 **/
public class CreateBinaryTree {
    public static void main(String[] args) {
        TreeNode node = CreateBinaryTree.createBT(new int[]{1, 2, 3, 4, 5,6}, 0);
        CreateBinaryTree.preOrder(node);
    }

    public static TreeNode createBT(int[] arr, int i) // 初始时,传入的i==0
    {
        TreeNode root = null; // 定义根节点

        if (i >= arr.length) // i >= arr.length 时,表示已经到达了根节点
            return null;

        root = new TreeNode(arr[i]); // 根节点
        root.left = createBT(arr, 2 * i + 1); // 递归建立左孩子结点
        root.right = createBT(arr, 2 * i + 2); // 递归建立右孩子结点

        return root;
    }

    /**
     * @description: 前序遍历
     */
    public static void preOrder(TreeNode root) {

        if (root == null) {
            return;
        } else {
            System.out.println("preOrder data:" + root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}