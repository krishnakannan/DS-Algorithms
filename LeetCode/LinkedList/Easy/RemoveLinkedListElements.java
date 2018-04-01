/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode trav = head;
        while (trav != null) {
            
            if (head.val == val) {
                head = head.next;
            }
            
            if (trav.val == val) {
                trav = trav.next;
            } else if (trav.next != null && val == trav.next.val) {
                trav.next = trav.next.next;
            } else {
                trav = trav.next;
            }
        }
        
        return head;
    }
}