/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
    	int length = getLength(root);
        List<Integer> splits = getSplits(length, k);
        ListNode[] splitParts = new ListNode[splits.size()];
        ListNode tHead = root;
        ListNode tTrav = root;
        int index = 0;
        for (Integer split : splits) {            
        	while (--split > 0) {        		
        		tTrav = tTrav.next;
        	}   
            ListNode temp = null;
            if (tTrav != null){
                temp = tTrav.next;            
        	    tTrav.next = null;    
            }        	
        	splitParts[index] = tHead;
            index++;
        	tHead = temp;
        	tTrav = tHead;
        }
        
        return splitParts;
    }

    public List<Integer> getSplits(int size, int k) {
    	List<Integer> splits = new ArrayList<>();
    	int rem = size % k;
    	int singleSplit = size / k;
    	while (size > 0) {         
    		if (rem > 0) {
    			splits.add(singleSplit + 1);	
                size -= singleSplit;
                size--;
    		} else {
    			splits.add(singleSplit);	
                size -= singleSplit;
    		}               
    		rem--;
            k--;
    	}        
        while (k > 0) {
            splits.add(0);
            k--;
        }                
    	//System.out.println(splits);
        return splits;
    }

    public int getLength(ListNode root) {
    	ListNode trav = root;
    	int length = 0;
    	if (root == null) {
    		return 0;
    	}
    	while (trav != null) {
    		length++;
    		trav = trav.next;
    	}
    	return length;
    }
}