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
    TreeNode[] nodes = new TreeNode[4];
    
    TreeNode inorderPredecessor = null;
    public void recoverTree(TreeNode root) {                
    	parseBST(root);
    	//This is constant space
     	for (int i = 0; i < 4; i++) {
            if (nodes[i] != null) {
                for (int j = i + 1; j < 4; j++) {
                    if (nodes[j] != null) {
                        if (nodes[i].val > nodes[j].val) {
                            int temp = nodes[i].val;
                            nodes[i].val = nodes[j].val;
                            nodes[j].val = temp;
                        }    
                    }     			
                }   
            }     		
     	}     	
    }
    
    public void parseBST(TreeNode root) {                
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {            
            if (inorderPredecessor == null || root.val > inorderPredecessor.val) {
                inorderPredecessor = root;
            } else {
            	if (nodes[0] == null) {
            		nodes[0] = inorderPredecessor;
            		nodes[1] = root;
            	} else if (nodes[2] == null) {
            		nodes[2] = inorderPredecessor;
            		nodes[3] = root;
            	}                
            	inorderPredecessor = root;
            }    
            return;        
        }                
        
        parseBST(root.left);
        if (inorderPredecessor == null || root.val > inorderPredecessor.val) {
        	inorderPredecessor = root;	
        } else {
        	if (nodes[0] == null) {
                nodes[0] = inorderPredecessor;
                nodes[1] = root;
            } else if (nodes[2] == null) {
                nodes[2] = inorderPredecessor;
                nodes[3] = root;
            }                   
        	inorderPredecessor = root;
        }        
        parseBST(root.right);        
    }    
}