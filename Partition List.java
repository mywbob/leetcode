/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    //find the first node that >= x, then find all nodes < x, put them before 
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode index = head;
        ListNode firstLOrE = index;
        ListNode beforeFirstLOrE = dummy;
        ListNode findSmaller = null;
        while (index != null) {
            if (index.val >= x) {firstLOrE = index; break;}
            index = index.next;
            beforeFirstLOrE = beforeFirstLOrE.next;
        }
        
        if (index == null) return dummy.next;
        
        findSmaller = index.next;
        ListNode beforeFindSmaller = index;
        while (findSmaller != null) {
            if (findSmaller.val < x) {
                //put before 
                ListNode next = findSmaller.next;
                beforeFindSmaller.next = next;
                beforeFirstLOrE.next = findSmaller;
                findSmaller.next = firstLOrE;
                beforeFirstLOrE = findSmaller;
                findSmaller = next;
                continue;
            }
            //go next;
            findSmaller = findSmaller.next;
            beforeFindSmaller = beforeFindSmaller.next;
        }
        
        
        //check if head can change
        return dummy.next;
    }
}