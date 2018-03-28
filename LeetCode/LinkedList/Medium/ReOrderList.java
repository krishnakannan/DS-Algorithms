/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<ListNode> stack = new Stack<>();
    public void reorderList(ListNode head) {        
        ListNode trav = head;
        while (trav != null) {
            stack.push(trav);
            trav = trav.next;
        }
        trav = head;
        ListNode lastNode = null;
        while (!stack.empty()) {
            lastNode = stack.pop(); 
            if (lastNode == trav.next || lastNode == trav) {                
                break;
            }
            lastNode.next = trav.next;
            trav.next = lastNode;
            trav = lastNode.next;            
        }
        
        if (lastNode != null) {
            lastNode.next = null;
        }        
    }
}ReOrder