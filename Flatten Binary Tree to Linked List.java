/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
	public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.left = null;
            root.right = left;
            flatten(root.right);
            while (root.right != null) {
                root = root.right;
            }
        }

        root.right = right;
        flatten(root.right);
        
    }
	
	
	
	
	
	//old
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode right = null;
        

        right = root.right;
        root.right = root.left;
        root.left = null;
        flatten(root.right);
        
        
        while (root.right != null) {//find the last
            root = root.right;
        }

        root.right = right;
        flatten(root.right);
    }
}


public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        
        if (left != null) {
            root.right = left;
            root.left = null;
            flatten(root.right);
            while (root.right != null) {
                root = root.right;
            }
        }
        
        
        
        //connect right
        root.right = right;
        flatten(root.right);
    }
}