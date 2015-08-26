/*
Given a binary tree, return the inorder traversal of its nodes' values.
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
	public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        TreeNode cur = root;
        boolean done = false;
        while (!done) {//stop condition
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                if (stack.isEmpty()) { break;} //when stack empty and cur is null, all finished
                
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
                
            }
        }
        
        return res;
    }
	
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        boolean done = false;
        while(!done) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {//done
                    done = true;
                } else {//go right
                    root = stack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
            
        }
        return res;
    }
}