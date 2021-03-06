/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
 
 //Pick a number i between 1..n as the root, and take all numbers less than i as the left sub tree, and all numbers greater than i as the right sub tree. Recursively construct the BST.
 
 //how can i figure out the helper need start end as args? how to figure out the end condition?
public class Solution {
	public List<TreeNode> generateTrees(int n) {
        return build(1,n);
    }
    
    public List<TreeNode> build(int s, int e) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (s>e) {
            res.add(null);//this is important
            return res;
        }
        
        for (int i = s; i<=e; i++) {
            List<TreeNode> left = build(s,i-1);
            List<TreeNode> right = build(i+1,e);
            for (TreeNode l : left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(i);//new root here
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
	
	
	
	
	
	
	
	
//old
public ArrayList<TreeNode> generateTrees(int n) {
    return helper(1, n);
}

public ArrayList<TreeNode> helper(int s, int e){
    ArrayList<TreeNode> result = new ArrayList<TreeNode>();//each call has a new result

    if(s > e){
        result.add(null);
        return result;
    }

    for(int i = s; i <= e; i++){//root from s to e, <= 
        ArrayList<TreeNode> left = helper(s, i-1);//all the left subtree, with root smaller than i, a copy of result
        ArrayList<TreeNode> right = helper(i+1, e);//all the right subtree, with root larger than i, a copy of result

        for(TreeNode tl : left){
            for(TreeNode tr : right){
                TreeNode r = new TreeNode(i);
                r.left = tl;
                r.right = tr;
                result.add(r);
            }
        }
    }

    return result;
}
}
