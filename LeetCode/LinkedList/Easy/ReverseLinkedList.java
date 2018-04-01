/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode node = head;
        ListNode next = node.next;
        
        while (node != null) {
            node.next = prev;
            prev = node;
            node = next;
            if (node != null) {
                next = node.next;    
            }
        }
        
        return prev;
    }
}