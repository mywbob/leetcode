/*
Given a binary tree, return the preorder traversal of its nodes' values.
*/

/*
no clear idea!!!!
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) return res;
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            res.add(root.val);
            if (root.right != null) {
                st.push(root.right);
            }
            
            if (root.left != null) {
               st.push(root.left);
            }
        }
  
        return res;
    }
    

}