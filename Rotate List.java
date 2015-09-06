/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode index = head;
        int cnt = 0;
        while (index!=null) {
            cnt++;
            index=index.next;
        }
        k = k % cnt;
        if (k == 0) return head;

        index = head;
        cnt = cnt-k-1;
        while (cnt>0) {
            index = index.next;
            cnt--;
        }
        
        ListNode newhead = index.next;
        index.next = null;
        index = newhead;
        while (index.next != null) {
            index = index.next;
        }
        index.next = head;
        
        return newhead;
        
    }
}