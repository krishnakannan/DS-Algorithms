import java.util.*;
import java.lang.*;
import java.io.*;

class LongestConsecutiveSequence {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(lcs.longestConsecutive(nums));		
	}

    public int longestConsecutive(int[] numArray) {
 		Set<Integer> nums = new HashSet<>();
 		for (int num : numArray) {
 			nums.add(num);
 		}       

 		Set<Integer> visited = new HashSet<>();
 		Queue<Integer> bfsQ = new LinkedList<>();
 		int maxLength = Integer.MIN_VALUE;
 		for (int i = 0; i < numArray.length; i++) {
 			if (!visited.contains(numArray[i])) {
 				int currentNum = numArray[i]; 				 			
 				bfsQ.add(currentNum); 		
 				int length = 0;		
 				while (!bfsQ.isEmpty()) { 					
 					int polled = bfsQ.poll();
 					length++;
 					visited.add(polled);
 					if (!visited.contains(polled + 1) && nums.contains(polled + 1)) {
 						bfsQ.add(polled + 1);
 					} 
 					if (!visited.contains(polled - 1) && nums.contains(polled - 1)) {
 						bfsQ.add(polled - 1);
 					}
 				}
 				maxLength = maxLength < length ? length : maxLength;
 			}
 		}
 		return maxLength;
    }


}