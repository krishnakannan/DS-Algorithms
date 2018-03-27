/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     
        return build(0, inorder.length - 1, inorder, preorder, 0);

    }


    public TreeNode build(int start, int end, int[] inorder, int[] preorder, int pIndex) {
    
        if (start > end) {
            return null;
        }
            
        if (start == end) {
            TreeNode leaf = new TreeNode(inorder[start]);
            return leaf;
        }

        TreeNode node = new TreeNode(preorder[pIndex]);

        int inorderIndex = getIndex(inorder, preorder[pIndex]);
        int lsTreeSize = inorderIndex - start + 1;
        //System.out.println("Start " + start + " End " + end +  " Element " + preorder[pIndex] + " pINdex " + pIndex + " inOIndex " + inorderIndex);
        int rsTreeSize = end - inorderIndex + 1;

        node.left = build(start, inorderIndex - 1, inorder, preorder, pIndex + 1);

        node.right = build(inorderIndex + 1, end, inorder, preorder, pIndex + lsTreeSize);

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