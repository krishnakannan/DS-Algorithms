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
    int maxLength = 0;
    boolean rootAdded = false;
    public int longestConsecutive(TreeNode root) {
    	traverse(root);
    	return maxLength;   
        
    }
    
    public void traverse(TreeNode root) {
    	if (root == null) {
    		return;    		
    	}

    	if (root.left == null && root.right == null) {
    		maxLength = maxLength < 1 ? 1 : maxLength;
    		return;
    	}

        int incLeft = getDepth(root.left, root.val, true);        
        int decRight = getDepth(root.right, root.val, false);        
        int decLeft = getDepth(root.left, root.val, false);
        int incRight = getDepth(root.right, root.val, true);
        
        int length1 = incLeft + 1 + decRight;
        int length2 = decLeft + 1 + incRight;
        
        maxLength = maxLength < length1 ? length1 : maxLength;
    	maxLength = maxLength < length2 ? length2 : maxLength;

        traverse(root.left);
    	traverse(root.right);
    }

    public int getDepth(TreeNode root, int parent, boolean isIncreasing) {

    	if (root == null) {
    		return 0;
    	}
        
    	if (root.left == null && root.right == null) {
    		if (isIncreasing) {
    			if (oneInc(parent, root.val)) {
    				return 1;
    			} else {
    				return 0;
    			}
    		} else {
    			if (oneDec(parent, root.val)) {                 
    				return 1;
    			} else {
    				return 0;
    			}
    		}
    	}

    	int length1 = 0;
    	int length2 = 0;

    	if (root.left != null) {
    		if (isIncreasing) {
    			if (oneInc(parent, root.val)) {                    
    				int l1 = getDepth(root.left, root.val, isIncreasing);		
                    length1 = length1 < l1 ? l1 : length1;                   
    			} 
    		} else {
    			if (oneDec(parent, root.val)) {
                    
    				int l2 = getDepth(root.left, root.val, isIncreasing);                                        
                    length2 = length2 < l2 ? l2 : length2;
    			}
    		}
    	}

    	if (root.right != null) {
    		if (isIncreasing) {
    			if (oneInc(parent, root.val)) {
    				int l1 = getDepth(root.right, root.val, isIncreasing);		
                    length1 = length1 < l1 ? l1 : length1;
    			} 
    		} else {
    			if (oneDec(parent, root.val)) {
    				int l2 = getDepth(root.right, root.val, isIncreasing);                    
                    length2 = length2 < l2 ? l2 : length2;
    			}
    		}
    	}
    	        
        int retVal = length1 > length2 ? length1 : length2;
        if (isIncreasing) {
            if (oneInc(parent, root.val)) {
                retVal++;
            }
        } else {
            if (oneDec(parent, root.val)) {
                retVal++;
            }
        }
    	return retVal;
    }

    // a is parent b is child

    public boolean oneInc(int a, int b) {
    	return b - a == 1;    	
    }

    public boolean oneDec(int a, int b) {
    	return a - b == 1;    	
    }
}