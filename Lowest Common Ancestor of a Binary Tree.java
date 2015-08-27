/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
 
 //http://articles.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
 //http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 /*
 1:The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present). If root doesn’t match with any of the keys, we recur for left and right subtree. The node which has one key present in its left subtree and the other key present in right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree. q, p need exist in this tree.
 2: cnt p, q = 0,1,2, then like bst case 
 */
public class Solution {
	
	//assume q, p in the tree
    //1: top down, four cases
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right != null) return right;
        else if (right == null && left != null) return left;
        else if (right == null && left == null) return null; 
        else return root;
        
    }
    
    
    //2: bf, count the nodes in the tree, assume q, p in the tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        if (count(root.left, p, q) == 2) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (count(root.left, p, q) == 0) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
        
    }
    
    public int count(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        if (root == q || root == p) return count(root.left, p, q) + count(root.right, p, q) + 1;
        else return count(root.left, p, q) + count(root.right, p, q);
    }
	
	//old
    //1: o(n), p, q need to exist in this tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!= null && right != null) return root;
        else return (left!=null) ? left: right;
    }
}