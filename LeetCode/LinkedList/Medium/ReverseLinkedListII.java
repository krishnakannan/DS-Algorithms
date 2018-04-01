/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode trav = head;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = null;
        ListNode x1 = null;
        ListNode x2 = null;
        if (m > 1) {
            x1 = head;
            x2 = head.next;    
        } else {
            x1 = null;
            x2 = head;
        }
        
        
        for (int i = 1; i < m - 1; i++) {
                x1 = x1.next;
                x2 = x2.next;
        }
        
        //System.out.println(" X1 = " + x1.val + " X2 = " + x2.val);
        p2 = x2;
        p3 = p2.next;
        
        for (int i = m; i <= n; i++) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p2 != null) {
                p3 = p2.next;    
            }
        }
        // System.out.println("P1 = " + p1.val);
        // System.out.println(" P2 = " + p2.val);
        // System.out.println(" P3 = " + p3.val);
        // System.out.println(" X1 = " + x1.val + " X2 = " + x2.val);
        if (x1 != null) {
            x1.next = p1;    
        }
        if (x2 != null) {
            x2.next = p2;    
        }
        
        return m == 1 ? p1 : head;
        
    }
}