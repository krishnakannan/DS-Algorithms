/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	boolean[] unvisited;
    public int numComponents(ListNode head, int[] G) {
        unvisited = new boolean[10000];
        int connectedComponents = 0;
        for (int i = 0; i < G.length; i++) {
        	unvisited[G[i]] = true;
        }

        ListNode trav = head;
        boolean parsingConnected = false;
        while (trav != null) {
        	if (unvisited[trav.val]) {
        		unvisited[trav.val] = false;        		
        		parsingConnected = true;
        		if (trav.next == null) {
        			connectedComponents += 1;
        		}
        	} else {
        		if (parsingConnected) {
                    //System.out.println("Unconnected " + trav.val);
        			connectedComponents += 1;
        			parsingConnected = false;	
        		}        		
        	}

        	trav = trav.next;
        }

        return connectedComponents;
    }
}