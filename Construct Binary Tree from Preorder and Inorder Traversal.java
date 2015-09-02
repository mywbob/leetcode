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
        if (inorder == null || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);

        int p =0;
        while (inorder[p] != preorder[0]) {
            p++;
        }
        
        int[] inorderL = Arrays.copyOfRange(inorder, 0, p);
        int[] preorderL = Arrays.copyOfRange(preorder, 1, p+1);
        int[] inorderR = Arrays.copyOfRange(inorder, p+1, inorder.length);
        int[] preorderR = Arrays.copyOfRange(preorder,p+1, preorder.length);
        
        TreeNode left = buildTree(preorderL, inorderL);
        TreeNode right = buildTree(preorderR, inorderR);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}