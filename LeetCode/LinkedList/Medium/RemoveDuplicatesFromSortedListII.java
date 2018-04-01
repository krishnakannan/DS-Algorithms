/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode trav = head;
        boolean isDuplicate = false;
        while (trav != null) {
            if (!stack.empty()) {
                if (stack.peek().val == trav.val) {
                    isDuplicate = true;
                } else if (isDuplicate) {
                    isDuplicate = false;
                    stack.pop();
                    if (stack.empty()) {
                        head = trav;
                    } else {
                        stack.peek().next = trav;    
                    }
                    stack.push(trav);
                } else {
                    isDuplicate = false;
                    stack.push(trav);
                }
            } else {
                stack.push(trav);
            }
            trav = trav.next;
        }
        if (isDuplicate) {
            stack.pop();
            if (stack.empty()) {
                head = null;
            } else {
                stack.peek().next = null;    
            }
            
        }
        
        return head;
    }
}