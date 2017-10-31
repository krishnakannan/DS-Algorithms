import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/minimum-platforms/0

class MinimumPlatforms {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MinimumPlatforms mp = new MinimumPlatforms();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arrival = new int[n];
		    int[] departure = new int[n];
		    for (int i = 0; i < arrival.length; i++) {
		        arrival[i] = in.nextInt();
		    }			
			for (int i = 0; i < arrival.length; i++) {
		        departure[i] = in.nextInt();
		    }
		    System.out.println(mp.requiredPlatforms(arrival, departure));
 		}
	}

	public int requiredPlatforms(int[] arrival, int[] departure) {
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int plat = 1;
		int max = 1;
		int i = 1, j = 0;		
		while (i < arrival.length && j < arrival.length) {
			if (arrival[i] < departure[j]) {
				plat++;
				i++;
				max = max < plat ? plat : max;
			} else {
				plat--;
				j++;
			}
		}
		return max;
	}
}