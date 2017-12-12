/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/merge-k-sorted-lists/
class Solution {	

	ListNode newHead = null;
    public ListNode mergeKLists(ListNode[] lists) {

        //Create a MinHeap for the List

        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
        	public int compare (ListNode l1, ListNode l2) {
        		return l1.val - l2.val;
        	}
        });

        for (int i = 0; i < lists.length; i++) {
        	if (lists[i] != null) {
                minHeap.add(lists[i]);    
            }  
        }

        //Lists will be populated in the Heap
        ListNode trav = null;
        if (newHead == null) {
        	newHead = minHeap.peek();        	
        }

        while (!minHeap.isEmpty()) {
        	ListNode tempHead = minHeap.poll();
        	if (trav != null) {
        		trav.next = tempHead;
        	}
        	trav = tempHead;
        	tempHead = tempHead.next;
        	trav.next = null;        
        	if (tempHead != null) {
        		minHeap.add(tempHead);
        	} 
        }
        return newHead;
    }

}