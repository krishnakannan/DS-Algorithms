import java.util.*;
import java.lang.*;
import java.io.*;

class SoupServing {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SoupServing ss = new SoupServing();
		int n = in.nextInt();
		System.out.println(ss.soupServings(n));
	}


	Map<String, Double> dp;
	int count = 0;
    public double soupServings(int n) {
    	if (n > 6000) {
    		/*
    		 A minor finding - any number greater than 6000 gives > 0.999999 the precision required is 10 ^ -6;
			
			Dont know how 6000 affects the speed - check again later.
    		*/
            return 1;
        }
        dp = new HashMap<>();
        double probability = getProbability(n, n, 1);

        return probability;
    }


    public double getProbability(int t1, int t2, double currentProbability) {
    	String remaining = t1 + "#" + t2;


    	if (dp.containsKey(remaining)) {
    		count++;
    		return dp.get(remaining);
    	}

    	if (t2 <= 0 && t1 <= 0) {
    		dp.put(remaining, currentProbability / 2);
    		return dp.get(remaining);
    	} else if (t1 <= 0) {
    		dp.put(remaining, currentProbability);
    		return dp.get(remaining);
    	} else if (t2 <= 0) { 
    		dp.put(remaining, 0d);
    		return dp.get(remaining);
    	}

    	double nextProbability = currentProbability / 4;
    	double probability = getProbability(t1 - 100, t2, nextProbability) + getProbability(t1 - 75, t2 - 25, nextProbability) + getProbability(t1 - 50, t2 - 50, nextProbability) + getProbability(t1 - 25, t2 - 75, nextProbability);

    	dp.put(remaining, probability);
    	return dp.get(remaining);

    }
}