/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode list = null;
        while (l1 != null || l2 != null) {
            while (l1 != null && l2 != null) {
                ListNode node = new ListNode((l1.val + l2.val + carry) % 10);
                if (head == null) {
                    head = node;
                    list = node;
                } else {
                    list.next = node;
                    list = node;
                }
                carry = (l1.val + l2.val + carry) > 9 ? 1 : 0;  
                l1 = l1.next;
                l2 = l2.next;
            }
            
            if (l1 != null) {
                ListNode node = new ListNode((l1.val + carry) % 10);
                list.next = node;
                list = node;
                carry = (l1.val + carry) > 9 ? 1 : 0;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                ListNode node = new ListNode((l2.val + carry) % 10);
                list.next = node;
                list = node;
                carry = (l2.val + carry) > 9 ? 1 : 0;
                l2 = l2.next;
            }
        }
        
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            list.next = node;
            list = node;
        }
        
        return head;
    }
}