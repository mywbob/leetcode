/*
Given a binary tree, return the postorder traversal of its nodes' values.
*/

/*
why need visited?
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode lastNodeVisited = null;
        
        while (!parentStack.empty() || root != null) {
            if (root != null) {
                parentStack.push(root);
                root = root.left;
            }
            else {
                TreeNode peekNode = parentStack.peek();
                if (peekNode.right != null && lastNodeVisited != peekNode.right)
                /* if right child exists AND traversing node from left child, move right */
                    root = peekNode.right;//change root
                else {
                    parentStack.pop();
                    res.add(peekNode.val);//visit node;
                    lastNodeVisited = peekNode;
                }
            }
        }
        return res;
    }
}