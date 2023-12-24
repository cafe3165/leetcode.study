package leetcode.jianzhi2;

/**
 * Author:cafe3165
 * Date:2022-12-01
 */
public class T35copyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p != null) {
            Node q = new Node(p.val);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
        p = head;
        while (p != null) {
            Node q = p.next;
            if (p.random != null) {
                q.random = p.random.next;
            }
            p = q.next;
        }
        Node newHead = head.next;
        p = newHead;
        while (p.next != null) {
            Node q = p.next;
            p.next = q.next;
            p = p.next;
        }

        return newHead;

    }

    public static void main(String[] args) {
        T35copyRandomList t = new T35copyRandomList();
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);
        n7.next = n13;
        n13.next = n11;
        n11.next = n10;
        n10.next = n1;
        n13.random = n7;
        n11.random = n1;
        n10.random = n11;
        n1.random = n7;

        Node head = t.copyRandomList(n7);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }


}
