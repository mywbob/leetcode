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
        if (postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int point = inorder[0];
        int i=0;
        while (point != root.val) {
            point = inorder[++i];
        }
        int[] inorderl = Arrays.copyOfRange(inorder, 0 , i);
        int[] postorderl = Arrays.copyOfRange(postorder, 0 , i);
        int[] inorderr = Arrays.copyOfRange(inorder, i+1, inorder.length);
        int[] postorderr = Arrays.copyOfRange(postorder, i, postorder.length-1);
        
        
        TreeNode left = buildTree(inorderl, postorderl);
        TreeNode right = buildTree(inorderr, postorderr);
        root.left = left;
        root.right = right;
        return root;
    }
}