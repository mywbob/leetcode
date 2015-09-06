/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> ares = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum);
        return res;
    }
    
    public void dfs(TreeNode node, int sum) {
        if (node == null) return;
        ares.add(node.val);
        
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new ArrayList<Integer>(ares));
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum-node.val);
            ares.remove(ares.size()-1);
        }
        if (node.right != null) {
            dfs(node.right, sum-node.val);
            ares.remove(ares.size()-1);
        }
    }
}