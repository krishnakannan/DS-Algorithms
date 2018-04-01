/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = null;
        ListNode p2 = null;
        if (head == null) {
            return head;
        }
        
        while (--n >= 0) {
            if (p1 == null) {
                p1 = head; 
            } else {
                p1 = p1.next;    
            }
        }
        
        while (p1 != null && p1.next != null) {
            p1 = p1.next;
            if (p2 == null) {
                p2 = head; 
            } else {
                p2 = p2.next;    
            }
        }
        
        if (p2 == null) {
            head = head.next;
        } else {
            p2.next = p2.next.next;
        }
        
        return head;
    }
}