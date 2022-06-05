package leetcode.editor.cn.test;

import leetcode.editor.cn.domain.ListNode;
import leetcode.editor.cn.domain.ListUtils;

import java.io.File;
import java.util.*;


public class Test2 {
    public static void main(String[] args) {
        ListNode head = ListUtils.creatListByArr(new int[]{1, 2, 3});
        ListNode reverseList = ListUtils.reverseList(head);
        ListUtils.printList(reverseList);
    }



}
