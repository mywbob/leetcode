/*
A linked list can be reversed either iteratively or recursively. Could you implement both?
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next== null) return head;
        ListNode perv = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = perv;
            perv = cur;
            cur = next;
        }
        return perv;
    }

    
    //recur method review
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next== null) return head;
        ListNode next = head.next;
        head.next =null;
        ListNode newhead = reverseList(next);
        next.next = head;
        return newhead;
        
    }
	
	
	

	//old
    //iteratively
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = list.size() - 1; i >0; i--) {
            list.get(i).next = list.get(i-1);
        }
        list.get(0).next = null;
        return list.get(list.size() -1);
    }
	
	//iteratively, important, o(n) time, o(1) space
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    
    //recursively
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}