/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/



/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 public class Solution {
	public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfs(root, 0, res);
        return res[0];
    }
    
    public void dfs(TreeNode root, int sum, int[] res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum = 10 * sum + root.val;
            res[0] = res[0] + sum;
            return;
        }
        sum = 10 * sum + root.val;
        dfs(root.left, sum, res);
        dfs(root.right,sum, res);
    }
	 
	 
	 
	 
	 
	 //
    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;
        int pathsum = 0;//this is pass by value, do not need to remove manully
        int[] totalsum = new int[1];
        sumPath(root, pathsum, totalsum);
        return totalsum[0];
    }
    public void sumPath(TreeNode root, int pathsum, int[] totalsum) {
        if (root == null) return;
        pathsum = 10 * pathsum + root.val;
        if (root.left == null && root.right == null) {
            totalsum[0] = totalsum[0] + pathsum;
            return;
        }
        
 
        sumPath(root.left, pathsum, totalsum);

        
        sumPath(root.right, pathsum, totalsum);

        
        
    }
}
 
 