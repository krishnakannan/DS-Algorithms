nn/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
    	return build(0, inorder.length - 1, inorder, postorder, postorder.length - 1);

    }


    public TreeNode build(int start, int end, int[] inorder, int[] postorder, int pIndex) {
    
        if (start > end) {
            return null;
        }
            
    	if (start == end) {
    		TreeNode leaf = new TreeNode(inorder[start]);
    		return leaf;
    	}

    	TreeNode node = new TreeNode(postorder[pIndex]);

    	int inorderIndex = getIndex(inorder, postorder[pIndex]);
    	int lsTreeSize = inorderIndex - start + 1;
        // System.out.println("Start " + start + " End " + end +  "Element " + postorder[pIndex] + " pINdex " + pIndex + " inOIndex " + inorderIndex);
    	int rsTreeSize = end - inorderIndex + 1;

    	node.left = build(start, inorderIndex - 1, inorder, postorder, pIndex - rsTreeSize);

    	node.right = build(inorderIndex + 1, end, inorder, postorder, pIndex - 1);

    	return node;

    }

    public int getIndex(int[] order, int element) {
    	for (int i = 0; i < order.length; i++) {
    		if (order[i] == element) {
    			return i;
    		}
    	}
    	return -1;
    }
}