/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
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
 
 /*
1: from node == root, check if p and q at diff side of node
2: if same side, node go that side
3: if not same side, node is the lca
4: if equal to q or p, node is the lca
5: what if one of q, p is null or both null
6: what if root is null
*/

public class Solution {
	//p, q in this tree or not? if can be null?
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == q || root == p) return root;
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > q.val && root.val < p.val || root.val > p.val && root.val < q.val) {//else
            return root;
        }
        
        return null;//never
    }
	
	//old
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (q == null || p == null) return null;
        if (root.val == q.val) return q;
        if (root.val == p.val) return p;
        if (root.val > p.val && root.val < q.val || root.val < p.val && root.val > q.val) return root;
        if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestor(root.left, p, q);
        if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestor(root.right, p, q);
        return null; //whatever
    }
}