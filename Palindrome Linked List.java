/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
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
	public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        //divide, find second half
        ListNode fast = head;
        ListNode slow = head;
        ListNode cutpoint = null;
        while (!(fast==null || fast.next== null)) {//easy to make mistakes
            cutpoint = slow;
            fast = fast.next.next;
            slow = slow.next;
            
        }
        cutpoint.next = null;//cut the list
        ListNode newhead = slow;
        
        
        //reverse second half, slow
        ListNode perv = null;
        ListNode cur = newhead;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = perv;
            perv = cur;
            cur = next;
        }
        newhead = perv;
        
        //compare
        ListNode index1 = head;
        ListNode index2 = newhead;
        while (index1 != null) {
            if (index1.val != index2.val) return false;
            index1 = index1.next;
            index2 = index2.next;
        }
        return true;
        
    }
	
	
	//old
    /*
    1: divide the list to two lists
    2: reverse one half
    3: compare
    */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode runner1 = head;
        ListNode runner2 = head;
        ListNode head2;
        while (!(runner2 == null || runner2.next == null)) {//easy to make mistakes this line
            runner1 = runner1.next;
            runner2 = runner2.next.next;
        }
        head2 = runner1;
        head2 = reverse(head2);
        
        while (head2 != null && head != null) {
            if (head2.val != head.val) return false;
            head2 = head2.next;
            head = head.next;
        }
        
        return true;
        
    }
    
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
}