package leetcode.editor.cn.domain;

/**
 * 链表工具类
 *
 * @author zhongye
 * @since 2022.05.17
 */
public class ListUtils {

    /**
    * 根据数组创建链表
    */
    public static ListNode creatListByArr(int[] arr){
        ListNode head = new ListNode(0);
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        for (int value : arr) {
            head.next = new ListNode(value);
            head = head.next;
        }
        return dummyHead.next.next;
    }

    /**
    * 遍历打印链表
    */
    public static void printList(ListNode head){
        if(head==null){
            System.out.println("输入链表为null");
        }
        StringBuilder builder = new StringBuilder();
        while(head!=null){
            if (head.next!=null){
                builder.append(head.val).append("-");
            }else {
                builder.append(head.val).append("-").append("null");
            }
            head = head.next;
        }
        System.out.println(builder.toString());
    }

    /**
    * 反转链表
    */
    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return head ;

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
