package src.main.java;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        var cur = head;
        for (int i = 2; i < 6; i++) {
            var newNode = new ListNode(i);
            cur.next = newNode;
            cur = newNode;
        }
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        var newNode = reverseLinkedList.reverseList2(null, head);
        cur = newNode;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;  // 4 -> 5 => 5 -> 4,     3 -> 4 => 4 -> 3,       2 -> 3 => 3 -> 2       1 -> 2 => 2 -> 1
        head.next = null;       // 4 -> null,            3 -> null               2 -> null              1 -> null
        return newHead;
    }

    public ListNode reverseList2(ListNode prev, ListNode curNode) {
        if (curNode == null) return prev;
        var next = curNode.next;
        curNode.next = prev;
        return reverseList2(curNode, next);
    }
}
