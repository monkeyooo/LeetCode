package src.main.java;

import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result;
        if (l1 != null && l2 != null && l1.val < l2.val) {
            result = l1;
        } else if (l1 != null && l2 != null && l1.val > l2.val){
            result = l2;
        } else if (l1 == null) {
            result = l2;
        } else if (l2 == null)
            result = l1;
        else
            return null;
        ListNode pointer = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return result;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
