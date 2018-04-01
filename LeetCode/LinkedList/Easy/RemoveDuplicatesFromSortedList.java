/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode trav = head;
        while (trav != null && trav.next != null) {
            if (trav.val == trav.next.val) {
                trav.next = trav.next.next;
            } else {
                trav = trav.next;
            }
            
        }
        
        return head;
    }
}