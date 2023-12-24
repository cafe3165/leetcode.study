package leetcode.daily;

import leetcode.ListNode;

/**
 * Author:cafe3165
 * Date:2023-04-23
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode p = reverseList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }


    }


}
