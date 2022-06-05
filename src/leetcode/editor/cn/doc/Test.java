package leetcode.editor.cn.doc;


import leetcode.editor.cn.domain.ListNode;

public abstract class Test {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node3;
        node3.next= node4;
        node4.next=node5;
        node5.next = node4;
        node2.next = node3;

        System.out.println(getResult(node1, node2).val);
    }

    public static ListNode  getResult(ListNode headA,ListNode headB){
        ListNode cycleNodeA = detectCycle(headA);
        ListNode cycleNodeB = detectCycle(headB);

        if (cycleNodeA==cycleNodeB){ // 如果入环节点相同,则两有环单链表相交
            ListNode A = headA, B = headB;
            while (A != B) {
                A = A != cycleNodeA ? A.next : headB;
                B = B != cycleNodeA ? B.next : headA;
            }
            return A;
        }

        return null; // 两有环单链表不相交
    }

    // 返回入环节点
    public static ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null) return null;
        ListNode quick = head;
        ListNode slow = head;
        while (true){
            if(quick==null||quick.next==null) return null;
            quick = quick.next.next;
            slow = slow.next;
            if (quick==slow) break;
        }
        quick = head;
        while (slow!=quick){
            slow = slow.next;
            quick = quick.next;
        }
        return quick;
    }

}



