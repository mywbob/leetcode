/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;
        if (l1 == null && l2 == null) return null;
        ListNode index1 = l1;
        ListNode index2 = l2;
        int cnt1 =0;
        int cnt2 =0;
        while (index1 != null) {
            index1 = index1.next;
            cnt1++;
        }
        while (index2 != null) {
            index2 = index2.next;
            cnt2++;
        }
        if (cnt1 < cnt2) {
            ListNode temp;
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        index1 = l1;
        index2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (index1 !=null) {
            int l2temp;
            if (index2 !=null) {
                l2temp = index2.val;
            } else {
                l2temp = 0;
            }
            
            int bit = (index1.val + l2temp + carry) % 10;
            carry = (index1.val + l2temp + carry) / 10;
            ListNode c = new ListNode(bit);
            cur.next = c;
            
            cur = cur.next;
            index1 = index1.next;
            if (index2 != null) index2 = index2.next;
            
        }
        
        if (carry == 1) {
            ListNode last = new ListNode(1);
            cur.next = last;
        }
        
        return dummy.next;
    }
}