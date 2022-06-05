package leetcode.editor.cn.domain;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2020-10-22 15:22
 **/
public  class TreeUtils {

    /**
     * @description: 前序遍历
     */
    public static void preTraverse(TreeNode root){
        if (root ==null) {
            return;
        }
        System.out.printf(root.val+" ");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * @description: 后序遍历
     */
    public static void backTraverse(TreeNode root){
        if (root ==null) {
            return;
        }
        preTraverse(root.left);
        preTraverse(root.right);
        System.out.printf(root.val+" ");
    }

    /**
     * @description: 中序遍历
     */
    public static void inTraverse(TreeNode root){
        if (root ==null) {
            return;
        }
        preTraverse(root.left);
        System.out.printf(root.val+" ");
        preTraverse(root.right);
    }
}
