/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean isPal = true;
    ListNode trav;
    ListNode headNode;
    boolean isHead = true;
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return isPal;
        }
        if (isHead) {
            isHead = false;
            headNode = head;
        }
        
        if (head.next != null) {
            isPalindrome(head.next);
        }
        
        if (headNode.val != head.val) {
            isPal = false;
        }
        headNode = headNode.next;
        return isPal;
    }
}