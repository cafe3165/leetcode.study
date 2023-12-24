package leetcode.jianzhituji;

import leetcode.ListNode;

import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2023-04-23
 */
public class T26reorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        int count = 0;
        ListNode p = head;
        while(p != null) {
            count++;
            p = p.next;
        }
        p = head;
        int cur = 0;
        while(cur < count/2) {
            p = p.next;
            cur++;
        }
        if (count % 2 != 0) {
            p = p.next;
        }
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;
        cur = 0;
        while (cur < count / 2) {
            ListNode node = stack.pop();
            node.next = p.next;
            p.next = node;
            p = node.next;
            cur++;
        }
        p.next = null;

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
        reorderList(head);
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }



    }
}
