/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
*/

	public void rotate(Node head,int k) {
        
        Node tail = head;
        while (tail.next != null) {
        	tail = tail.next;
        }
		while (--k >= 0) {
			Node nextNode = head.next;
			tail.next = head;
			tail = tail.next;
			head = nextNode;
			tail.next = null;			
		}
		Node trav = head;
		while(trav != null) {
			System.out.print(trav.data + " ");
			trav = trav.next;
		}
	}
