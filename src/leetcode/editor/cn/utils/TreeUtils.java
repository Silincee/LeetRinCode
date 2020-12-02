package leetcode.editor.cn.utils;

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
        if (root ==null) return;
        System.out.println(root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }
}
