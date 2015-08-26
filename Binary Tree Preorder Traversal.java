/*
Given a binary tree, return the preorder traversal of its nodes' values.
*/

/*
no clear idea!!!!
1) Create an empty stack nodeStack and push root node to stack.
2) Do following while nodeStack is not empty.
….a) Pop an item from stack and print it.
….b) Push right child of popped item to stack
….c) Push left child of popped item to stack

Right child is pushed before left child to make sure that left subtree is processed first.
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
	
	//do not think about the recursion...just look at the stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return res;
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                res.add(cur.val);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                cur = cur.left;
            } else {
                if (stack.isEmpty()) break;
                cur = stack.pop();
            }
        }
        return res;
    }
	
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