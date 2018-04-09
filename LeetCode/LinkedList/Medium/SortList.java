/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
 		if (head == null || head.next == null) {
 			return head;
 		}       

 		return mergeSort(head, getLast(head));
    }


    public ListNode mergeSort(ListNode start, ListNode end) {    	 
    	if (start == end) {
    		return start;
    	} else if (end == null) {
    		return start;
    	}


    	ListNode middle = getMiddle(start, end);    	    	
    	ListNode middlePlusOne = middle.next;
    	//Split the list
    	middle.next = null;


    	ListNode l1 = mergeSort(start, middle);
    	ListNode l2 = mergeSort(middlePlusOne, end);

    	return merge(l1, l2);

    }

    public ListNode merge(ListNode first, ListNode second) {
    	if (first == null) {
    		return second;
    	}
    	if (second == null) {
    		return first;
    	}

    	ListNode head = first.val < second.val ? first : second;

    	ListNode t1 = first;
    	ListNode t2 = second;

    	ListNode merged = null;

    	while (t1 != null && t2 != null) {
    		if (merged == null) {
    			if (t1.val < t2.val) {
    				merged = t1;
    				t1 = t1.next;    				
    			} else {
    				merged = t2;
    				t2 = t2.next;
    			}
    			merged.next = null;
    		} else {
    			if (t1.val < t2.val) {
    				merged.next = t1;
    				t1 = t1.next;    				
    			} else {
    				merged.next = t2;
    				t2 = t2.next;
    			}
    			merged = merged.next;
    			merged.next = null;
    		}
    	}

    	if (t1 != null) {
    		merged.next = t1;
    	} else if (t2 != null) {
    		merged.next = t2;
    	}

    	return head;
    }

    public ListNode getMiddle(ListNode start, ListNode end) {
    	ListNode trav1 = start;
    	ListNode trav2 = start;
    	while (trav2 != end && trav2.next != end) {
    		trav2 = trav2.next.next;
    		trav1 = trav1.next;
    	}
    	return trav1;
    }

    public ListNode getLast(ListNode start) {
    	ListNode trav = start;
    	while (trav != null && trav.next != null) {
    		trav = trav.next;
    	}
    	return trav;
    }

    public void printList(ListNode start) {
        ListNode trav = start;
        while (trav != null) {
            System.out.print(trav.val + " -> ");
            trav = trav.next;
        }
        System.out.println();
    }

}