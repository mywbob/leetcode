/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }
    
    public boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null && r != null) return false;
        if (l != null && r == null) return false; 
        if (l.val != r.val) return false;
        return check(l.left, r.right) && check(l.right, r.left);
    }
}