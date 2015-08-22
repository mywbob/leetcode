/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode mid;
        ListNode index = head;
        int cnt = 0;
        //find mid, 
        while (index!=null) {
            index = index.next;
            cnt++;
        }
        index = head;
        cnt = cnt / 2;
        ListNode prev = null;
        while (cnt!=0) {
            if (cnt==1) {
                prev = index;
            }
            index = index.next;
            cnt--;

        }
        
        
        mid = new TreeNode(index.val);
        
        //find first and second
        ListNode first;
        if (prev != null) {
            first = head;
            prev.next = null;//cut the list
        } else {
            first = null;
        }
        
        ListNode second = index.next;
        index.next = null;//cut the list
        
        mid.left = sortedListToBST(first);
        mid.right = sortedListToBST(second);
        return mid;
    }
}