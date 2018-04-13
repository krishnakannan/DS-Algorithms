/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = getSize(head);
        if (length < k || k == 0 || k == 1) {
        	return head;
        } 
        int remainingLength = length;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        ListNode newHead = null;
        ListNode currentHead = null;
        while (current != null && remainingLength >= k) {
        	currentHead = current;
        	int iter = k;
        	while (--iter >= 0) {
        		current.next = prev;
        		prev = current;
        		current = next;
        		next = next != null ? next.next : next;
        	}
        	if (remainingLength == length) {
        		newHead = prev;                		
        	}
            remainingLength -= k;		
        	
            if (remainingLength >= k) {
                int tempK = k;
                ListNode tempTrav = current;
                while (--tempK > 0) {
                    tempTrav = tempTrav.next;
                }
                currentHead.next = tempTrav;
                prev = null;
            }            
        }
        currentHead.next = current;

        return newHead;

    }

    public int getSize(ListNode head) {
    	int size = 0;
    	ListNode trav = head;
    	while (trav != null) {
    		size++;
    		trav = trav.next;
    	}
    	return size;
    }
}