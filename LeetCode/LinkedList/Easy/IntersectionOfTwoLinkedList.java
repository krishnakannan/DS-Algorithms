/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = getListLength(headA);
        int bLen = getListLength(headB);
        int len = aLen > bLen ? aLen - bLen : bLen - aLen;
        ListNode aTrav = headA;
        ListNode bTrav = headB;
        while (--len >= 0) {
            System.out.println("Hre");
            if (aLen > bLen) {
                aTrav = aTrav.next;
            } else {
                bTrav = bTrav.next;
            }
        }
        
        while (aTrav != null && bTrav != null) {
            if (aTrav == bTrav) {
                return aTrav;
            } else {
                aTrav = aTrav.next;
                bTrav = bTrav.next;
            }
        }
        
        return null;
        
    }
    
    public int getListLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;    
            node = node.next;
        }
        return length;
    }
}