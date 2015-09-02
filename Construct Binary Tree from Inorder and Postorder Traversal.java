/*
Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        
        int p =0;
        while (inorder[p] != postorder[postorder.length-1]) {
            p++;
        }
        
        
        int[] inorderL = Arrays.copyOfRange(inorder, 0, p);
        int[] postorderL = Arrays.copyOfRange(postorder, 0, p);
        int[] inorderR = Arrays.copyOfRange(inorder, p+1, inorder.length);
        int[] postorderR = Arrays.copyOfRange(postorder,p, postorder.length-1);
        
        
        TreeNode left = buildTree(inorderL, postorderL);
        TreeNode right = buildTree(inorderR, postorderR);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}