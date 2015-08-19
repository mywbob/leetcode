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
    List<List<Integer>> res =new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum, temp, res);
        return res;
    }
    
    public void dfs(TreeNode node, int sum,  List<Integer> temp, List<List<Integer>> res) {
        temp.add(node.val); 
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                res.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        
        if (node.left != null) {
            dfs(node.left, sum- node.val, temp, res);
            temp.remove(temp.size() - 1);
        }

        if (node.right != null) {
            dfs(node.right, sum-node.val, temp, res);
            temp.remove(temp.size() - 1);
        }
        
    
    }
}