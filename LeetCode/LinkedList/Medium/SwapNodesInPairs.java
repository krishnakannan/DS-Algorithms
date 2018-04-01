/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nHead = head;
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = null;
        
        while (p1 != null && p1.next != null && p2 != null) {
            
            if (p1 == head) {
                nHead = p2;
            }
            
            if (p3 != null) {
                p3.next = p2;    
                p3 = p1; 
            } else {
                p3 = head;
            }
            
            p1.next = p2.next;
            p2.next = p1;
            if (p1 != null) {
                p1 = p1.next;    
            }
            if (p1 != null) {
                p2 = p1.next;
            }
            
            
        }
        
        return nHead;
    }
}