/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
  Pairwise swap a linked list
  The input list will have at least one element  
  node is defined as 
  struct node
  {
     int data;
     struct node *next;
  }
*/
//http://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1

void pairWiseSwap(struct node *head)
{
   if (head == NULL || head->next == NULL) {
		return;
	}

	struct node* p1 = head;
	struct node* p2 = head->next;
	while (p1 != NULL && p2 != NULL) {
		int swap = p1->data;
		p1->data = p2->data;
		p2->data = swap;
		p1 = p2->next;
		if (p1 != NULL) {
			p2 = p1->next;	
		}		
	}
}

