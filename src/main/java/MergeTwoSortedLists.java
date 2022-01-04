package src.main.java;

import java.util.List;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]
Example 2:
        Input: list1 = [], list2 = []
        Output: []
Example 3:
        Input: list1 = [], list2 = [0]
        Output: [0]
*/

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode listNodel11 = new ListNode(1);
        ListNode listNodel12 = new ListNode(2);
        ListNode listNodel13 = new ListNode(4);
        listNodel11.next = listNodel12;
        listNodel12.next = listNodel13;
        ListNode listNodel21 = new ListNode(1);
        ListNode listNodel22 = new ListNode(3);
        ListNode listNodel23 = new ListNode(4);
        listNodel21.next = listNodel22;
        listNodel22.next = listNodel23;
        var res = mergeTwoLists(listNodel11, listNodel21);
        while (res != null) {
            System.out.print(res.val+ " ");
            res = res.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode res;
        if (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                res = l2;
                l2 = l2.next;
            } else {
                res = l1;
                l1 = l1.next;
            }
        } else if (l1 == null) {
            return l2;
        } else {
            return l1;
        }
        head = res;
        while (l1 != null || l2 != null) {
            ListNode newNode = new ListNode();
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    newNode.val = l2.val;
                    l2 = l2.next;
                } else {
                    newNode.val = l1.val;
                    l1 = l1.next;
                }

            } else if (l1 == null) {
                newNode.val = l2.val;
                l2 = l2.next;
            } else {
                newNode.val = l1.val;
                l1 = l1.next;
            }
            res.next = newNode;
            res = res.next;
        }
        return head;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
