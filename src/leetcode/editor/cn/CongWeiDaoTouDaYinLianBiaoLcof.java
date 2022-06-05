//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 79 👎 0


package leetcode.editor.cn;

//从尾到头打印链表

import leetcode.editor.cn.domain.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class CongWeiDaoTouDaYinLianBiaoLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion) https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 方法二：辅助栈法
 */
class Solution {
	ArrayList<Integer> tmp = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
		LinkedList<Integer> stack = new LinkedList<>();
		while (head!=null){
			stack.addLast(head.val);
			head=head.next;

		}
		int[] res = new int[stack.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = stack.removeLast();
		}
		return res;

	}

}
//leetcode submit region end(Prohibit modification and deletion)

}