/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastPtr = head.next.next;
        ListNode slowPtr = head;
        
        while (fastPtr != null && slowPtr != null && fastPtr.next != null && slowPtr.next != null) {
            if (fastPtr == slowPtr) {
                return true;    
            } 
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        
        return false;
    }
    
}