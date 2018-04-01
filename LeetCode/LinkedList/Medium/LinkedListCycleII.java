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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slowPtr = head.next;
        ListNode fastPtr = head.next.next;
        
        while (slowPtr != fastPtr) {
            if (fastPtr == null || fastPtr.next == null) {
                return null;
            } 
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        slowPtr = head;
        
        while (slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        
        return fastPtr;
        
    }
}