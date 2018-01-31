/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
 		int celebrity = -1;
        boolean hasFound = false;

 		for (int i = 0; i < n && !hasFound; i++) {
 			for (int j = 0; j < n; j++) {
 				if (i != j) {
 					if (knows(j, i) && !knows(i, j)) {
 						celebrity = i;
                        hasFound = true;
 					} else {
 						celebrity = -1;
                        hasFound = false;
 						break;
 					}
 				}
 			}
 		}

 		return celebrity;       
    }
}