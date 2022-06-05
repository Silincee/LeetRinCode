//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针 
// 👍 745 👎 0


package leetcode.editor.cn;

//环形链表


import leetcode.editor.cn.domain.ListNode;

public class P141_LinkedListCycle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P141_LinkedListCycle().new Solution();
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(solution.hasCycleLength(node0));
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        // 方法二 双指针
        // 通过使用具有不同速度的快、慢两个指针遍历链表，慢指针每次移动一步，而快指针每次移动两步。
        // 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
        public boolean hasCycle(ListNode head) {
            if (head == null||head.next==null)  return false;

            ListNode slow = head;
            ListNode fast = head.next;
            while (fast!=null&&fast.next!=null){
                if (fast==slow) return true;
                slow = slow.next;
                fast = fast.next.next;
            }

            return false;
        }

        public int hasCycleLength(ListNode head) {
            if (head==null||head.next==null) return -1;
            ListNode quick = head;
            ListNode slow = head;
            while (true){
                if(quick==null||quick.next==null) return -1;
                quick = quick.next.next;
                slow = slow.next;
                if (quick==slow) break;
            }
            int count = 1;
            quick = quick.next;
            while (slow!=quick){
                slow = slow.next;
                quick = quick.next.next;
                count++;
            }
            return count;
        }


        }
//leetcode submit region end(Prohibit modification and deletion)

    }

