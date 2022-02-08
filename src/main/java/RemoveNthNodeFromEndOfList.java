package src.main.java;


//Given the head of a linked list, remove the nth node from the end of the list and return its head.


public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        //test cases
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        removeNthFromEnd(node, 3);
        removeNthFromEnd(node5, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode prev = head;
        int totalLength = 0;
        while(cur != null) {
            cur = cur.next;
            totalLength++;
        }
        cur = head;
        int nodeIndex = totalLength - n;
        int index = 0;
        while (cur != null) {
            if (index == 0 && index == nodeIndex) {
                return cur.next;
            } else if (index == nodeIndex) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
            index++;
        }
        return head;
    }
}



class ListNode {
 int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
