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
        if (head == null) return head;
        ListNode index = head;
        int cnt=0;
        while ( index != null) {
            index = index.next;
            cnt++;
        }
        
        k = k % cnt;
        if (k == 0) return head;
        
        k = cnt - k -1;
        index = head;
        ListNode temp = null;
        while (k!= 0) {
            index = index.next;
            k--;
        }
        
        ListNode newhead = index.next;
        index.next = null;
        
        index = newhead;
        while (index.next!= null) {
            index = index.next;
        }
        index.next =head;
 
        
        
        return newhead;
    }
}