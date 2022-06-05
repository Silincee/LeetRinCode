package leetcode.editor.cn.BinaryTree;

import leetcode.editor.cn.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树工具类
 *
 * @author zhongye
 * @since 2021.08.21
 */
public class BinaryTreeUtils {
    private static ArrayList<Integer> list = new ArrayList<>();

    /**
     * 根据数组创建一颗二叉树，null用#表示
     */
    public static TreeNode createBT(String s) {
        String[] arr = s.split(",");

        // 定义根节点
        TreeNode root = null;
        return createBT(arr, 0);
    }

    private static TreeNode createBT(String[] arr, int i) {
        // 定义根节点
        TreeNode root = null;

        // i >= arr.length 时,表示已经到达了根节点
        if (i >= arr.length || arr[i].equals("#")) {
            return null;
        }

        // 根节点
        root = new TreeNode(Integer.parseInt(arr[i]));
        // 递归建立左孩子结点
        root.left = createBT(arr, 2 * i + 1);
        // 递归建立右孩子结点
        root.right = createBT(arr, 2 * i + 2);

        return root;
    }

    /**
     * 前序遍历
     */
    public static List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtils.createBT("1,2,3,#,5,#,4");
        List<Integer> list = BinaryTreeUtils.preOrder(root);
        System.out.println("前序遍历结果: " + list.toString());
    }
}