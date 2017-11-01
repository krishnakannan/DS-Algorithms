/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*The Node is defined as
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
        Node(){}
    }
*/

//http://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

class GfG
{
	Node addTwoLists(Node first, Node second) {
        if (first == null && second == null) {
            return null;
        } else if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }

       Node sum = new Node();
       sum.next = null;
       Node trav = sum;
       int carry = 0;
       sum.data = (first.data + second.data) % 10; 
       carry = (first.data + second.data) >= 10 ? 1 : 0;
       first = first.next;
       second = second.next;


       while (first != null && second != null) {
            Node node = new Node();
            node.data = (first.data + second.data + carry) % 10; 
            carry = (first.data + second.data + carry) >= 10 ? 1 : 0;
            first = first.next;
            second = second.next;            
            trav.next = node;
            trav = node;
       }

       if (first == null) {
            while (second != null) {
                Node node = new Node();
                node.data = (second.data + carry) % 10; 
                carry = (second.data + carry) >= 10 ? 1 : 0;            
                second = second.next;            
                trav.next = node;
                trav = node;
            }            
       } else if (second == null) {
            while (first != null) {
                Node node = new Node();
                node.data = (first.data + carry) % 10; 
                carry = (first.data + carry) >= 10 ? 1 : 0;            
                first = first.next;            
                trav.next = node;
                trav = node;
            }            
       }
       if (carry == 1) {
        Node node = new Node(1);
        trav.next = node;
        trav = node;
       }
       return sum;

	}
}