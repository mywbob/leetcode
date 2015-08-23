/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        Queue<TreeNode> temp;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        if (root == null) return res;
        cur.add(root);
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            row.add(node.val);
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
            
            if (cur.isEmpty()) {
                temp = cur;
                cur = next;
                next = temp;
                res.add(new ArrayList<Integer>(row));
                row.clear();
            }
        }
        boolean reverse = false;
        for (List<Integer> l : res) {
            if (reverse) {
                Collections.reverse(l);
            } 
            
            reverse = !reverse;
        }
        
        return res;
    }
}