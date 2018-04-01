/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode trav = null;
        ListNode head = trav;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int temp = 0;
                if (l1.val < l2.val) {
                    temp = l1.val;
                    l1 = l1.next;
                } else {
                    temp = l2.val;
                    l2 = l2.next;
                }
                ListNode node = new ListNode(temp);
                node.next = null;
                if (head == null) {
                    head = node;
                    trav = head;
                } else {
                    trav.next = node;
                }
                trav = node;
            } else if (l1 != null) {
                int temp = l1.val;
                ListNode node = new ListNode(temp);
                node.next = null;
                if (head == null) {
                    head = node;
                    trav = head;
                } else {
                    trav.next = node;
                }
                trav = node;
                l1 = l1.next;
            } else if (l2 != null) {
                int temp = l2.val;
                ListNode node = new ListNode(temp);
                node.next = null;
                if (head == null) {
                    head = node;
                    trav = head;
                } else {
                    trav.next = node;
                }
                trav = node;
                l2 = l2.next;
            }
        }   
        
        return head;
    }
}