/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 == null) return null;
        ListNode newhead = new ListNode(0);
        ListNode h = newhead;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                newhead.next = l2;
                l2 = l2.next;
            } else {
                newhead.next =l1;
                l1 = l1.next;
            }
            newhead = newhead.next;
        }
        if (l1 == null) newhead.next = l2;
        else newhead.next = l1;
        
        
        return h.next;
        
    }
}