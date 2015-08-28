/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //1:most easiest way, swap value
 //2 swap node
public class Solution {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode index1 = head;
        ListNode index2 = head.next;
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        while (index1 != null && index2 != null) {
            index1.next = index2.next;
            index2.next = index1;
            index.next = index2;
            
            index = index1;
            index1 = index1.next;
            if (index1 == null) break;
            index2 = index1.next;

        }
        
        
        return dummy.next;
    }
	
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode first = head;
        ListNode second = head.next;
        ListNode next;
        ListNode perv = dummy;
        ListNode temp;
        boolean foundnewhead = false;
        while (first !=null && second != null) {
            next = second.next;
            second.next = first;
            first.next = next;
            perv.next = second;
            if (!foundnewhead) {
                dummy.next = second;
                foundnewhead = true;
            }
            
            //swap first and second...
            temp = second;
            second = first;
            first = temp;
            
            //move first and second, easy to make mistakes..perv
            perv = second;
            first = first.next.next;
            if (first == null || first.next == null) return dummy.next;
            second = second.next.next;//attention:null exception
        }
        
        
        
        
        
        return dummy.next;
        
    }
}