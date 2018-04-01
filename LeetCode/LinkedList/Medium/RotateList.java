/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        } else if (k == 0) {
            return head;
        }
        int length = 0;
        ListNode trav = head;
        while (trav != null) {
            length++;
            trav = trav.next;
        }
        int kAbs = k % length;
        if (kAbs == 0) {
            return head;
        }
        int toPass = length - kAbs;
        ListNode nHead = null;
        ListNode ntrav = head;
        for(int i = 1; i < toPass; i++) {
            ntrav = ntrav.next;
        }
        nHead = ntrav.next;
        ntrav.next = null;
        ntrav = nHead;
        while (ntrav.next != null) {
            ntrav = ntrav.next;
        }
        ntrav.next = head;
        return nHead;
    }
}