package leetcode.jianzhi2;

import leetcode.ListNode;

import java.util.LinkedList;

/**
 * Author:cafe3165
 * Date:2023-02-21
 */
public class T27isPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int num = 0;
        ListNode p = head;
        while(p != null) {
            num ++;
            p = p.next;
        }
        p = head;
        int m = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while(m < num/2) {
            m++;
            stack.addLast(p.val);
            p = p.next;
        }
        if (num % 2 != 0) {
            p = p.next;
        }
        while (p != null) {
            Integer peek = stack.removeLast();
            if (p.val != peek) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T27isPalindrome t = new T27isPalindrome();
        int[] nums = new int[]{1,2,2,1};
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            p.next = node;
            p = p.next;
        }



        t.isPalindrome(head.next);
    }
}
