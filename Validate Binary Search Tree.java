/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean check(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return check(root.left, min, root.val) && check(root.right, root.val, max);
        
    }
}
 
 
 
 
 //1 inorder store, check if sorted, dfs idea
 //2 max min, overflow !
 /*
 
 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean check(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (!(root.val < max && root.val > min)) return false;
        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
}
*/

public class Solution {
    long last = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        if (!(isValidBST(root.left))) return false;
        if (root.val <= last) return false;
        last = root.val;
        if (!(isValidBST(root.right))) return false;
        
        return true;
    }
    

}