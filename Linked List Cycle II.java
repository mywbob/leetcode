/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

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
public class Solution {
	public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {//meet
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        
        return null;
        
    }
	
	//old
    public ListNode detectCycle(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        if (head == null || head.next == null) return null;
        
        while (!(runner == null || runner.next == null)) {
            runner = runner.next.next;
            walker = walker.next;
            if (runner == walker) {
                walker = head;
                while (runner != walker) {
                    runner = runner.next;
                    walker = walker.next;
                }
                return walker;
            }
        }
        return null;
        
    }
}