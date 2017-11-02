/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

//http://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1

class GfG
{
  Stack<Node> s1 = new Stack<>();
  Stack<Node> s2 = new Stack<>();
  void printSpiral(Node node) {
    s1.push(node);
    while (!s1.empty() || !s2.empty()) {

      if (s2.empty()) {        
        while (!s1.empty()) {
          Node temp = s1.pop();
          System.out.print(temp.data + " ");
          if (temp.right != null) {
            s2.push(temp.right);  
          }          
          if (temp.left != null) {
            s2.push(temp.left);
          }           
        }
      } else if (s1.empty()) {
        while (!s2.empty()) {
          Node temp = s2.pop();
          System.out.print(temp.data + " ");
          if (temp.left != null) {
            s1.push(temp.left);
          }           
          if (temp.right != null) {
            s1.push(temp.right);  
          }                    
        }
      }
    }
    System.out.println("Exit");
  }
}
