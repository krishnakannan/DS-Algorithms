/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> minStack = null;
    public BSTIterator(TreeNode root) {
        if (minStack == null) {
            minStack = new Stack<>();
        }
        pushStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
            return !minStack.empty();
        }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = minStack.pop();
        if (node.right != null) {
            pushStack(node.right);
        }
        return node.val;    
    }
    
    public void pushStack(TreeNode root) {
        while (root != null) {
            minStack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */