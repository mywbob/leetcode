/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
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
    //1: the kth element using inorder tra
    public int kthSmallest(TreeNode root, int k) {
        TreeNode[] res = new TreeNode[1];
        int[] kk = new int[1];
        kk[0] = k;
        dfs(root, kk, res);
        return res[0].val;
    }
    
    public void dfs(TreeNode root, int[] kk, TreeNode[] res) {
        if (root == null) return;
        //go left
        dfs(root.left, kk, res);
        //visit node
        kk[0]--;
        if (kk[0] == 0) {res[0] = root; return;}
        
        //go right
        dfs(root.right, kk, res);
    }
}