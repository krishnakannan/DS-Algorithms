import java.util.*;
import java.lang.*;   
import java.io.*;

class FreedomTrail {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String ring = in.next();
		String key = in.next();
		FreedomTrail ft = new FreedomTrail();
		System.out.println(ft.findRotateSteps(ring, key));
	}

	Map<String, int[]> memo;
    public int findRotateSteps(String ring, String key) {
    	memo = new HashMap<>();
     	return rotate(ring, 0, key.toCharArray(), 0);
    }



    public int rotate(String ring, int sIndex, char[] key, int kIndex) {


    	if (kIndex == key.length) {
    		return 0;
    	}    	

    	if (memo.containsKey(ring) && memo.get(ring)[kIndex] != 0) {
    		return memo.get(ring)[kIndex];
    	}

    	//Clockwise move rightwards
    	//AntiClockwise move leftwards
    	
        int clockwiseIndex = getPosition(ring, key[kIndex], false);
    	int clockwiseCost = ring.length() - clockwiseIndex;
    
        int anticlockwiseIndex = getPosition(ring, key[kIndex], true);
    	int anticlockwiseCost = anticlockwiseIndex;                 
        

     	anticlockwiseCost += rotate(ring.substring(anticlockwiseIndex) + ring.substring(0, anticlockwiseIndex), anticlockwiseIndex, key, kIndex + 1);

     	clockwiseCost += rotate(ring.substring(clockwiseIndex) + ring.substring(0, clockwiseIndex), clockwiseIndex, key, kIndex + 1);

     	int minCost = anticlockwiseCost < clockwiseCost ? anticlockwiseCost : clockwiseCost;

        memo.put(ring, new int[key.length]);
     	memo.get(ring)[kIndex] = minCost + 1;

     	return memo.get(ring)[kIndex];

     	//return minCost;

    }
    
    public int getPosition(String ring, char searchChar, boolean isForward) {
        if (isForward) {
            return ring.indexOf(searchChar);
        } else {
            if (ring.charAt(0) == searchChar) {
                return 0;  
            } 
            for (int i = ring.length() - 1; i > 0; i--) {
                if (ring.charAt(i) == searchChar) {
                    return i;
                }
            }
        }
        return 0;
    }
}