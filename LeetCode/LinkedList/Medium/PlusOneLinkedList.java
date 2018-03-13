/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        
    	Integer val = recurse(head);
    	if (val > 0) {
    		ListNode node = new ListNode(val);
    		node.next = head;
    		head = node;
    	}
    	return head;
	}

	public Integer recurse(ListNode head) {
		if (head == null) {
			return 1;
		}

		int carry = recurse(head.next);
		
		int val = head.val + carry;
		carry = val / 10;		
		head.val = val % 10;
		return carry;
	}
}