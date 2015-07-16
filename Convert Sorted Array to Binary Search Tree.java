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