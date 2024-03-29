//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1623 👎 0


package leetcode.editor.cn;

//合并两个有序链表

import leetcode.editor.cn.domain.ListNode;

public class P21_MergeTwoSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P21_MergeTwoSortedLists().new Solution();
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

	/**
	 * @description: 递归
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1==null){
			return l2;
		}
		if (l2==null){
			return l1;
		}

		if (l1.val<=l2.val){
			l1.next = mergeTwoLists(l1.next,l2);
			return  l1;
		}else {
			l2.next = mergeTwoLists(l1,l2.next);
			return l2;
		}
	}





	/**
	* @description: 迭代
	*/
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		ListNode dummyHead = new ListNode(-1);
//		ListNode prev = dummyHead;
//
//		while(l1!=null&&l2!=null){
//			if (l1.val<=l2.val){
//				prev.next = l1;
//				prev = l1;
//				l1 = l1.next;
//			}else{
//				prev.next = l2;
//				prev = l2;
//				l2 = l2.next;
//			}
//		}
//
//		prev.next = l1==null?l2:l1;
//
//		return dummyHead.next;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}