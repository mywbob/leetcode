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
        return isSymmetricSubTree(root.left, root.right);
    }
    
    public boolean isSymmetricSubTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null && node2 != null) return false;
        if (node1 != null && node2 == null) return false;
        if (node1 !=null && node2 != null) {
            if (node1.val != node2.val) return false;
        }
        return isSymmetricSubTree(node1.left, node2.right) && isSymmetricSubTree(node1.right, node2.left);
    }
}