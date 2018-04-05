/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //Referred

    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int count = 0;
        ListNode trav = head;
        ListNode candidate = head;
        while (true) {
            if (trav == null) {
                break;
            }
            if (rand.nextInt(count + 1) == count) {
             candidate = trav;
            }
            trav = trav.next;
            count++;
        }
        return candidate.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */