import java.util.*;
import java.lang.*;   
import java.io.*;

class FrogJump {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		FrogJump fj = new FrogJump();
		int n = in.nextInt();
		int[] stones = new int[n];
		for (int i = 0; i < stones.length; i++) {
			stones[i] = in.nextInt();
		}
		System.out.println(fj.canCross(stones));
		for (List<Integer> dpset : fj.dp) {
			System.out.println(dpset);
		}
	}

	Map<Integer, Set<Integer>> dp;
    public boolean canCross(int[] stones) {
       
        dp = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
        	dp.put(stones[i], new HashSet<>());
        }            
        
        dp.get(0).add(0);
        
        for (int i = 0; i < stones.length; i++) {        	
        	for (int jumps : dp.get(stones[i])) {
                for (int j = jumps - 1; j <= jumps + 1; j++) {
                    if (j > 0 && dp.containsKey(j + stones[i])) {
                        dp.get(j + stones[i]).add(j);
                    }
                }
            }
        }
        
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}