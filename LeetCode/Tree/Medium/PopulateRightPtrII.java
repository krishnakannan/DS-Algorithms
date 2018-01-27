/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
 		
 		TreeLinkNode level = root;
 		while (level != null) {
 			TreeLinkNode current = level;
 			while (current != null) {
 				if (current.left != null) {
 					if (current.right != null) {
 						current.left.next = current.right;	
 					} else { 						
 						if (current.next != null) {
 							TreeLinkNode curNext = current.next;
 							while (curNext != null && curNext.left == null && curNext.right == null) {
 								curNext = curNext.next;
 							}
 							if (curNext != null && curNext.left != null) {
 								current.left.next = curNext.left;	
 							} else if (curNext != null && curNext.right != null) {
 								current.left.next = curNext.right;	
 							}
 						}		 
 					}
 					
 				}

 				if (current.right != null && current.next != null) { 					
 					TreeLinkNode curNext = current.next;
					while (curNext != null && curNext.left == null && curNext.right == null) {
						curNext = curNext.next;
					}

 					if (curNext != null && curNext.left != null) {
						current.right.next = curNext.left;	
					} else if (curNext != null && curNext.right != null) {
						current.right.next = curNext.right;	
					}
 				}
 				current = current.next;
 			}
            
            while (level != null && level.left == null && level.right == null) {                                
                level = level.next;
            }
            if (level != null && level.left != null) {
                level = level.left;                    
            } else if (level != null && level.right != null) {
                level = level.right;
            } else {
                level = null;
            }                         			
 		}

    }
}