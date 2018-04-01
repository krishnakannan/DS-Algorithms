/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head.next;
        ListNode next = curr.next;
        ListNode nHead = head;
        nHead.next = null;
        while (curr != null) {
            ListNode trav = nHead;
            // ListNode x = nHead;
            // while (x != null) {
            //     System.out.print(x.val +  " -> ");
            //     x = x.next;
            // }
            // System.out.println();
            while (trav.next != null && curr.val > trav.next.val) {
                    trav = trav.next;
            }
            if (trav == nHead) {
                if (curr.val > trav.val) {
                    curr.next = trav.next;
                    trav.next = curr;
                } else {
                    curr.next = nHead;
                    nHead = curr;    
                }
                
            } else {
                curr.next = trav.next;
                trav.next = curr;
            }
            curr = next;
            if (next != null) {
                next = next.next;    
            }
            
        }
        
        return nHead;
    }
}