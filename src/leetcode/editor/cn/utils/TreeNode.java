package leetcode.editor.cn.utils;

/**
 * @program: LeetCode
 * @description: Definition for a binary tree node.
 * @author: Silince
 * @create: 2020-09-25 09:21
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}

