/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
class gfg
{
    Node MergeLists(Node headA, Node headB) {
      
      Node head = null;
      Node trav = null;
      Node travA = null;
      Node travB = null;
      if (headA == null) {
        return headB;
      }
      if (headB == null) {
        return headA;
      }

      if (headA.data < headB.data) {
        head = headA;
        trav = head;
        travA = headA.next;
        travB = headB;
      } else {
        head = headB;
        trav = head;
        travA = headA;
        travB = headB.next;
      }

      while (travA != null && travB != null) {
        if (travA.data < travB.data) {
          Node temp = new Node(travA.data);
          trav.next = temp;
          trav = temp;
          travA = travA.next;
        } else {
          Node temp = new Node(travB.data);
          trav.next = temp;
          trav = temp;
          travB = travB.next;
        }
      }

      if (travA == null) {
        while (travB != null) {
          Node temp = new Node(travB.data);
          trav.next = temp;
          trav = temp;
          travB = travB.next;
        }
      }
      if (travB == null) {
        while (travA != null) {
          Node temp = new Node(travA.data);
          trav.next = temp;
          trav = temp;
          travA = travA.next;
        }
      }
      return head;
   } 
}
