/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
 dummy head,
 find new value, check if dup, if no, add, if so, repeat
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        ListNode index1 = head;
        ListNode index2 = head.next;
        while (index2 != null) {
            if (index1.val != index2.val) {
                index.next = index1;
                index = index.next;
                index1 = index2;
                index2 = index2.next;
            } else {//find not equal
                while (index2 != null && index1.val == index2.val) {//care exp
                    index2 = index2.next;
                }
                if (index2 == null) break;
                index1 = index2;
                index2 = index2.next;
            }
        }
        
        //last
        if (index1.next == null) index.next = index1;
        else index.next = null;
        
        return dummy.next;
    }
	
	
	
	//old
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        ListNode index = dummyhead;
        while (curr != null) {
            if (curr.val != index.val) {//new value
                //check dup
                int cnt = 0;
                ListNode next = curr.next;
                while (next != null && next.val == curr.val) {
                    next = next.next;
                    cnt++;
                }
                
                if (cnt == 0) {// no dup
                    index.next = curr;
                    index = index.next;
                } else {
                    curr = next;
                    continue;
                }
                
            }
            curr = curr.next;
        }
        index.next = null;//important
        
        return dummyhead.next;
        
        
    }
}