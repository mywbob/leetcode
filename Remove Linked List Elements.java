/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
 Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummyhead = new ListNode(0);
        ListNode node = head;
        ListNode temp = dummyhead;
        while (node != null) {
            if (node.val != val) {
                temp.next = node;
                temp = node;
            } 
            node = node.next;
            
        }
        temp.next = null;//do not forget this
        return dummyhead.next;   
    }
}