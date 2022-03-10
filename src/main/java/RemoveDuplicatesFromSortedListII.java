package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode cur2 = head;
        ListNode dummy = new ListNode();
        ListNode ansHead = dummy;
        Map<Integer, Integer> map = new HashMap<>();
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                map.put(cur.val, map.get(cur.val) + 1);
            } else {
                map.put(cur.val, 1);
            }
            cur = cur.next;
        }
        while (cur2 != null) {
            if (map.containsKey(cur2.val) && map.get(cur2.val) == 1) {
                dummy.next = new ListNode(cur2.val);
                dummy = dummy.next;
            }
            cur2 = cur2.next;
        }

        return ansHead.next;

    }
}
