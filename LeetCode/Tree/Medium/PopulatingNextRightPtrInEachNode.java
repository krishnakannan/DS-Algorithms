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
 					current.left.next = current.right;
 				}
 				if (current.right != null && current.next != null) {
 					current.right.next = current.next.left;
 				}

 				current = current.next;
 			}
 			level = level.left;
 		}

    }
}