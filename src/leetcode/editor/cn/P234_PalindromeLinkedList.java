//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 912 👎 0


package leetcode.editor.cn;

//回文链表

import leetcode.editor.cn.utils.ListNode;

import java.util.ArrayList;

public class P234_PalindromeLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P234_PalindromeLinkedList().new Solution();
	 	 ListNode head = new ListNode(1);
	 	 head.next=new ListNode(2);
	 	 head.next.next=new ListNode(3);
	 	 head.next.next.next=new ListNode(2);
	 	 head.next.next.next.next=new ListNode(1);

	 	 solution.isPalindrome(head);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;ListNode fast = head;
		//通过快慢指针找到中点
		while (fast!=null&&fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}

		//如果fast不为空，说明链表的长度是奇数个
		if (fast!=null){
			slow = slow.next;
		}

		//反转后半部分链表 , 并把slow指向最后的元素
		 slow = reverse(slow);

		// 比较前后两部分链表
		fast = head;
		while (slow!=null){
			if (slow.val!=fast.val) return false;
			fast = fast.next;
			slow= slow.next;
		}

		return true;

	}

	//反转链表
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head!=null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;

		}
		return prev;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}