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

    
    //recursively
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}