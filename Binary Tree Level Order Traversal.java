/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ares = new ArrayList<Integer>();
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = null;
        
        if (root == null) return res;
        cur.add(root);
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            ares.add(node.val);
            if (node.left!= null) {
                next.add(node.left);
            }
            
            if (node.right!=null) {
                next.add(node.right);
            }
            
            if (cur.isEmpty()) {
                temp = cur;
                cur = next;
                next = temp;
                res.add(new ArrayList<Integer>(ares));
                ares.clear();
            }
        }
        
        return res;
    }
}