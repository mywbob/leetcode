/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newhead = head;
        ListNode index = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val != index.val) {
                index.next = cur;
                index = index.next;
            }
            cur = cur.next;
        }
        index.next = null;
        return newhead;
    }
	
	//old
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head.next;
        ListNode index = head;
        while (curr != null) {
            if (curr.val != index.val) {
                index.next = curr;
                index = index.next;
            }
            curr = curr.next;
        }
        index.next = null;//important!!
        
        return head;
        
    }
}