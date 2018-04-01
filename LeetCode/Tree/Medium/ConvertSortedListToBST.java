/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    TreeNode tree = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode last = head;
        int count = 1;
        while (last != null && last.next != null) {
            last = last.next;
            count++;
        }
        
        
        tree = traverse(head, last);
        return tree;
    }
    
    public TreeNode traverse(ListNode head, ListNode last) {
        if (head != null && last != null && head.val > last.val) {
            return null;
        }
        if (head == last || head == last.next) {
            if (head == null) {
                return null;
            }
            TreeNode node = new TreeNode(head.val);
            return node;
        }
            
        ListNode middle = middle(head, last);
        TreeNode node = new TreeNode(middle.val);
        ListNode temp = head;
        while (temp != null && temp.next != middle) {
            temp = temp.next;
        }
        node.left = traverse(head, temp);        
        node.right = traverse(middle.next, last);        
        return node;
    }
    
    public ListNode middle (ListNode first, ListNode last) {
        if (last == null) {
            return first;
        } 
        if (first == null) {
            return last;
        }
        ListNode p1 = first;
        ListNode p2 = first;
        
        while (p2 != last && p2 != last.next) {
            if (p1 != null && p2 != null && p2.next != null) {
                p1 = p1.next;    
                p2 = p2.next.next;    
            }
        }
        return p1;
    }
}