//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 151 👎 0


package leetcode.editor.cn;

//反转链表

import leetcode.editor.cn.utils.ListNode;

public class FanZhuanLianBiaoLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new FanZhuanLianBiaoLcof().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    	ListNode cur = head,pre = null;

		while (cur!=null){
			ListNode tmp = cur.next; // 暂存后继节点 cur.next
			cur.next = pre; // 修改next引用指向
			// pre 和 cur 都前进一步
			pre = cur;
			cur = tmp;
		}
		return pre;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}