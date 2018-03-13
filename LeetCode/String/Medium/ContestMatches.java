/*
	Works only for the powers of 2
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class ContestMatches {

	public static void main(String args[]) {
		ContestMatches cm = new ContestMatches();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(cm.findContestMatch(n));
	}

    public String findContestMatch(int n) {

    	List<String> matches = new ArrayList<>();
    	
    	for (int i = 1; i <= n; i++) {
    		matches.add(Integer.toString(i));
    	}

        return getContestMatches(n, 1, matches);
    }

    public String getContestMatches(int limit, int current, List<String> matches) {

    	if (limit == current) {
    		//System.out.println(matches);
    		return matches.get(0);
    	}

    	int size = matches.size();
    	int left = 0;
    	int right = size - 1;
    	List<String> currentMatches = new ArrayList<>();

    	while (left < right) {
    		currentMatches.add("(" + matches.get(left) + "," + matches.get(right) + ")");
    		left++;
    		right--;
    	}

    	return getContestMatches(limit, current * 2, currentMatches);
    }
}