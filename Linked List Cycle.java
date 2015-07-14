/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 
 //two ptrs
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        if (head == null || head.next == null) return false;
        
        while (!(runner == null || runner.next == null)) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) return true;
        }
        return false;
        
    }
}