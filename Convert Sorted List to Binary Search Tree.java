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
        ListNode index = head;
        ListNode first;
        ListNode second;
        boolean flag = false;
        
        //find mid and cut list
        int cnt = 0;
        while (index != null) {
            index = index.next;
            cnt++;
        }
        index = head;
        cnt =cnt/2;
        
        if (cnt == 0) flag = true;
        while (cnt != 0) {
            index = index.next;
            cnt--;
        }
        
        ListNode mid = index;
        
        if (!flag) {
            index = head;
            while (index.next != mid) {
                index = index.next;
            }
            first = head;
            index.next = null;//cut
        } else {
            first = null;
        }
        

        
        second = mid.next;
        mid.next = null; //cut
        
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(first);
        node.right = sortedListToBST(second);
        return node;
    }
	
	
	//old
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