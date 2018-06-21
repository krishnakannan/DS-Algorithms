import java.util.*;
import java.lang.*;
import java.io.*;

class HandOfStraights {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		HandOfStraights hos = new HandOfStraights();
		int n = in.nextInt();
		int[] hand = new int[n];
		for (int i = 0; i < hand.length; i++) {
			hand[i] = in.nextInt();			
		}
		int w = in.nextInt();
		System.out.println(hos.isNStraightHand(hand, w));
	}



    public boolean isNStraightHand(int[] hand, int w) {
    	TreeMap<Integer, Integer> map = new TreeMap<>();
    	for (int i = 0; i < hand.length; i++) {
    		map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
    	}    

    	while (!map.isEmpty()) {

    		int prev = map.firstKey() - 1;
    		int currentCount = 0;
            List<Integer> consecutive = new ArrayList<>();
    		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    			if (currentCount >= w) {
    				break;
    			}
    			int curr = entry.getKey();
    			if (curr - prev != 1) {
    				return false;
    			}
                consecutive.add(curr);
    			prev = curr;    			
    			currentCount += 1;
    		}
            removeEmpty(map, consecutive);
    		if (currentCount != w) {
    			return false;
    		}
    	}

    	return true;

    }

    public void removeEmpty(TreeMap<Integer, Integer> map, List<Integer> consecutive) {
        for (Integer c : consecutive) {            
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }    	
    }
}