/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}
This is method only submission.  You only need to complete the method. */

//http://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1

class GFG
{
	int intersectPoint(Node headA, Node headB)
	{
         int lengthA = 0;
         int lengthB = 0;
         int diff = 0;
         Node travA = headA;
         Node travB = headB;

         while (travA != null) {
         	lengthA++;
         	travA = travA.next;
         }

         while (travB != null) {
         	lengthB++;
         	travB = travB.next;
         }
         travA = headA;
         travB = headB;
         diff = lengthA > lengthB ? lengthA - lengthB : lengthB - lengthA;
         if (lengthA > lengthB) {
         	while (--diff >= 0) {
         		travA = travA.next;
         	} 
         } else {
         	while (--diff >= 0) {
         		travB = travB.next;
         	}
         }

         while (travA != null && travB != null) {
         	if (travA == travB) {
         		return travA.data;
         	} else {
         		travA = travA.next;
         		travB = travB.next;
         	}
         }
         return -1;
	}
}
