/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
	List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }
    
    public void dfs(TreeNode root, String str) {
        if (root == null) return;
        str = str + root.val + "->";
        
        if (root.left == null && root.right == null) {//reach leaf
            res.add(str.substring(0, str.length()-2));
        }
        
        
        if (root.left != null) {
            dfs(root.left, str );
        }
        if (root.right != null) {
            dfs(root.right, str);
        }
        
        
    }
	
	//old
    List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "", res);
        return res;
    }
    
    public void dfs(TreeNode root, String s, List<String> res) {
        if (root == null) return; 
        s = s + "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(s.substring(2,s.length()));
            return;
        }
        
        dfs(root.left, s, res);
        dfs(root.right,s, res);
        
        
    }
}