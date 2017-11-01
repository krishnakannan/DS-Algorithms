/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
  Sort the list of 0's,1's and 2's
  The input list will have at least one element  
  Node is defined as 
  class Node {
 int value;
  Node next;
  Node(int value) {
   this.value = value;
  }
}
*/

//http://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

class GFG
{
    Node mid = null;
    Node start = null;
    Node end = null;
    void linksort(Node head) {
        if (head == null) {
            return;
        }
        start = head;
        mid = start;
        end = start;
        sort();
    }
    
    void sort() {
        Stack<Node> stack = new Stack<>();
        while (end != null) {
            stack.push(end);
            end = end.next;
        }
        while (mid != null && !mid.equals(stack.peek())) {
            if (mid.value == 0) {
                int temp = mid.value;
                mid.value = start.value;
                start.value = temp;
                start = start.next;
                mid = mid.next;
            } else if (mid.value == 1) {
                mid = mid.next;
            } else if (mid.value == 2) {
                int temp = mid.value;
                mid.value = stack.peek().value;
                stack.peek().value = temp;
                stack.pop();
            }
        }
        if (mid.equals(stack.peek())) {
            if (mid.value == 0) {
                int temp = mid.value;
                mid.value = start.value;
                start.value = temp;
            }
        }
    }
}