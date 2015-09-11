/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        if (root == null) return res;
        cur.add(root);
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            
            if (node.left != null) {
                next.add(node.left);
            }
            
            if (node.right != null) {
                next.add(node.right);
            }
            
            if (cur.isEmpty()) {
                res.add(node.val);
                Queue<TreeNode> temp = null;
                temp = cur;
                cur = next;
                next = temp;
            }
        }
        
        return res;
    }
}