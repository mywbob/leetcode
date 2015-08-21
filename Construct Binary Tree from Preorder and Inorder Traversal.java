/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode root;
        if (preorder.length == 0) return null;
        else root = new TreeNode(preorder[0]);
        
        //find point
        int point = 0;
        while (inorder[point] != preorder[0]) {
            point++;
        }
        
        
        
        int[] leadingpreorder = Arrays.copyOfRange(preorder, 1, point+1);
        int[] tailingpreorder = Arrays.copyOfRange(preorder, point+1, preorder.length);
        int[] leadinginorder = Arrays.copyOfRange(inorder, 0, point+1);
        int[] tailinginorder =Arrays.copyOfRange(inorder, point+1, inorder.length);
        
        
        root.left = buildTree(leadingpreorder, leadinginorder);
        root.right = buildTree(tailingpreorder, tailinginorder);
        
        return root;
    }
}