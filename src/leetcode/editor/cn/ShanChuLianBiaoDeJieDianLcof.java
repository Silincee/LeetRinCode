//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 77 👎 0


package leetcode.editor.cn;

//删除链表的节点

import leetcode.editor.cn.utils.ListNode;

public class ShanChuLianBiaoDeJieDianLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
	 }
//力扣代码 https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/mian-shi-ti-18-shan-chu-lian-biao-de-jie-dian-sh-2/
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { // [4 5 1 9]
    public ListNode deleteNode(ListNode head, int val) {
    	if (head.val==val) return head.next; // 当应删除头节点 head 时，直接返回 head.next 即可。

    	ListNode pre = head, cur = head.next; // 初始化

    	while (cur!=null&&cur.val!=val){ // 定位节点： 当 cur 为空 或 cur 节点值等于 val 时跳出
    		pre = cur; // 保存当前节点索引，即 pre = cur 。
    		cur=cur.next; // 遍历下一节点，即 cur = cur.next
		}

		// 删除节点： 若 cur 指向某节点，则执行 pre.next = cur.next 。
		// 若 cur 指向 null ，代表链表中不包含值为 val 的节点。
    	if (cur!=null) pre.next = cur.next;

    	// 返回值： 返回链表头部节点 head 即可。
    	return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}