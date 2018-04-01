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
    
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode l3 = null;
        ListNode t3 = l3;
        
        while (t1 != null) {
            s1.push(t1);
            t1 = t1.next;
        }
        
        while (t2 != null) {
            s2.push(t2);
            t2 = t2.next;
        }
        
        int carry = 0;
        
        while (!s1.empty() || !s2.empty()) {
            int val = 0;
            if (!s1.empty()) {
                val += s1.pop().val;
            } 
            if (!s2.empty()) {
                val += s2.pop().val;
            }
            val += carry;
            carry = val / 10;
            val %= 10;
            ListNode temp = new ListNode(val);
            temp.next = null;
            if (l3 == null) {
                l3 = temp;
                t3 = l3;
            } else {
                t3.next = temp;
                t3 = t3.next;
            }
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = null;
            if (l3 == null) {
                l3 = temp;
                t3 = l3;
            } else {
                t3.next = temp;
                t3 = t3.next;
            }
        }
        return reverse(l3);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = head.next;
        while (p2 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3 != null ? p3.next : p3;
        }
        return p1;
    }
    
}