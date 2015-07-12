/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
 
 //1 bf, o(n*n), height call on every node repeatly
 //2 reduce the number of heigth call, check height while check if it is balanced, return -1 if not, o(n)
public class Solution {
    //1 bf
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left-right) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    public int height(TreeNode root){
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }
    
    
    //2
    public boolean isBalanced(TreeNode root) {
        if (height(root) == -1) return false;
        else return true;
        
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }
    
	
}