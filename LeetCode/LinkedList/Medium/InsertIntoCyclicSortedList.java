/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal, head);
            return head;
        }
        
        Node newNode = new Node(insertVal, null);
        Node trav = head;        
        while (trav.next != head) {
            //System.out.println("Current " + trav.val + " Next " + trav.next.val);
            if (trav.val > trav.next.val && (trav.next.val >= insertVal || trav.val <= insertVal)) {
                break;
            }
            if (trav.val <= insertVal && trav.next.val >= insertVal) {                
                break; 
            }
            trav = trav.next;
        }
        newNode.next = trav.next;
        trav.next = newNode;
        return head;
    }
}