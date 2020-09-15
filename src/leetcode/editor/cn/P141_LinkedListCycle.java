//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
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


import leetcode.editor.cn.utils.ListNode;

import java.util.HashSet;

public class P141_LinkedListCycle {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P141_LinkedListCycle().new Solution();
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
            // 空链表和长度为1的链表直接返回false
            if (head==null||head.next==null) return false;

            // 定义快慢指针，直到两个指针相遇都没有指向null则返回true
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow!=fast){
                if (fast==null||fast.next==null){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }

            return  true;
        }

/*        // 方法一 哈希表
        // 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
        // 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，
        // 并且该链表不是环形链表。如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> nodeSeen = new HashSet<>();
            while(head!=null){
                if (nodeSeen.contains(head)){
                    return true;
                }else {
                    nodeSeen.add(head);
                }
                head=head.next;
            }
            return false;
        }*/
        }
//leetcode submit region end(Prohibit modification and deletion)

    }

