/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }        
        return flattenList(head);
    }
    
    public Node flattenList(Node currentHead) {        
        Node localHead = null; 
        Node localTail = null; 
        Node trav = currentHead;        
        while (trav != null) {            
            Node newNode = new Node(trav.val, null, null, null);
            if (localHead == null) {
                localHead = newNode;
                localTail = localHead;
            } else {
                localTail.next = newNode;
                newNode.prev = localTail;
                localTail = newNode;    
            }
            if (trav.child != null) {
                Node fList = flattenList(trav.child);
                localTail.next = fList;
                fList.prev = localTail;
                while (localTail.next != null) {
                    localTail = localTail.next;
                }
            }
            trav = trav.next;
        }
        return localHead;
    }
}