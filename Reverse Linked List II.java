/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m== n) return head;
        
        int s=1;
        ListNode index = head;
        ListNode newHead = head;
        ListNode tailOfLeading = null;
        while (s!=m) {
            tailOfLeading = index;
            index = index.next;
            s++;
        }
        
        //find m point, reverse
        int diff = n-m+1;
        ListNode subListNewTail = index;
        ListNode subListNewHead = null;
        ListNode perv = null;
        ListNode next = null;
        while (diff != 0) {
            next = index.next;
            index.next = perv;
            perv = index;
            index = next;
            diff--;
        }
        
        subListNewHead = perv;
        
        
        
        //connect to leading
        if (tailOfLeading == null) newHead = subListNewHead;
        else tailOfLeading.next = subListNewHead;
        
        //connect to tailing
        subListNewTail.next = index;
        
        return newHead;
        
    }
}