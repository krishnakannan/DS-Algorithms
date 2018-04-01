/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }       
        ListNode nHead = null;
        ListNode nTrav = nHead;
        ListNode trav = head;
        
        while (trav != null) {
            if (trav.val < x) {
                ListNode temp = new ListNode(trav.val);
                temp.next = null;
                if (nHead == null) {
                    nHead = temp;
                    nTrav = nHead;
                } else {
                    nTrav.next = temp;
                    nTrav = nTrav.next;
                }
            }
            trav = trav.next;
        }
        
        trav = head;
        
        while (trav != null) {
            if (trav.val >= x) {
                ListNode temp = new ListNode(trav.val);
                temp.next = null;
                if (nHead == null) {
                    nHead = temp;
                    nTrav = nHead;
                } else {
                    nTrav.next = temp;
                    nTrav = nTrav.next;
                }
            }
            trav = trav.next;
        }
        
        return nHead;
    }
}