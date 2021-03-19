package leetcode.editor.cn.utils;

/**
 * @program: LeetCode
 * @description: Definition for a binary tree node.
 * @author: Silince
 * @create: 2020-09-25 09:21
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = null;
    }}

