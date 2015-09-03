/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
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

//bf, inorder trv tht tree, store all next smallest, but need o(n) space
//use stack to trv the tree. 
//Say there are n nodes in the tree, and you call next() to get them all. The total time of all next() calls is O(n) since n nodes will be pushed into the stack and then poped out. The average time is O(n)/n for each next() call, which is O(1).
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (!stack.isEmpty()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        
        return val;
    }
    
}



//bf
/*
public class BSTIterator {
    List<TreeNode> inorder = new ArrayList<TreeNode>();
    int cur = Integer.MAX_VALUE;
    public BSTIterator(TreeNode root) {
        if (root != null) {
            dfs(root);
            cur = 0;
        }
    }

   
    public boolean hasNext() {
        if (cur < inorder.size()) return true;
        return false;
    }


    public int next() {
        int val = inorder.get(cur).val;
        cur++;
        return val;
    }
    
    public void dfs(TreeNode node) {
        if (node == null) return;
        
        dfs(node.left);
        inorder.add(node);
        dfs(node.right);
    }
}
*/
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */