/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int cnt1 = 0;
        int cnt2 = 0;
        while (l1 != null) {
            l1 = l1.next;
            cnt1++;
        }
        
        while (l2 != null) {
            l2 = l2.next;
            cnt2++;
        }
        
        //l1 is the longer list
        if (cnt1 < cnt2) {
            l1 = headB;
            l2 = headA;
        } else {
            l1 = headA;
            l2 = headB;
        }
        
        int diff = Math.abs(cnt1 - cnt2);
        
        while (diff != 0) {
            l1 = l1.next;
            diff--;
        }
        
        while (l1 != null) {
            if (l1 == l2) return l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return null;
        
    }
}