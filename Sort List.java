/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    //merge sort 
    public ListNode sortList(ListNode head) {
        ListNode h = mergeSort(head);
        return h;
    }
    
    
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode headFirst = head;
        ListNode headSecond = null;
        
        //find headSecond, which is mid point
        ListNode indexFast = head;
        ListNode indexSlow = head;
        ListNode perv = null;
        while (!(indexFast == null || indexFast.next == null)) {
            perv = indexSlow;
            indexFast = indexFast.next.next;
            indexSlow = indexSlow.next;
        }
        //cut the list 
        perv.next = null;
        
        headSecond = indexSlow;
        
        
        
        //do i need new node as head?
        headFirst = mergeSort(headFirst);
        headSecond = mergeSort(headSecond);
        return merge(headFirst, headSecond);
    }
    
    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode newHead;
        if (h1.next == null && h2.next == null) {//connect the list from base case
            if (h1.val <= h2.val) {
                newHead = h1;
                h1.next = h2;
            } else {
                newHead = h2;
                h2.next = h1;
            }
            return newHead; 
        } else {//in place or create new
            ListNode dummy = new ListNode(0);
            ListNode index = dummy;
            newHead = dummy;
            
            while (h1 != null && h2 != null) {
                if (h1.val <= h2.val) {
                    index.next = h1;
                    h1 = h1.next;
                } else {
                    index.next = h2;
                    h2 = h2.next;
                }
                index = index.next;
            }
            
            if (h1 == null) {
                index.next = h2;
            } else {
                index.next = h1;
            }

            return newHead.next;
        }
    }
}