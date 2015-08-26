/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(0, nums.length-1, nums);
        
    }
    
    public TreeNode build(int s, int e, int[] nums) {
        if (s > e) return null;
        int mid = (s + e)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(s, mid-1, nums);
        node.right = build(mid+1, e, nums);
        return node;
    }
	
	//old
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(0, nums.length-1, nums);
    }
    
    public TreeNode build(int start, int end, int[] nums) {
        if (start > end) return null;
        int mid = (start + end) /2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = build(start, mid -1, nums);
        TreeNode right = build(mid+1, end, nums);
        root.left = left;
        root.right = right;
        return root;
    }
}