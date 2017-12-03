import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0

class Permutations {

	//Only Capital Letters Supported
	
	List<String> permutations = new ArrayList<>(); 
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		Permutations p = new Permutations();
		while (--testcases >= 0) {
		    String str = in.next();		
		    p.findPermutations(str);		    
		    for (String s : p.permutations) {
		    	System.out.print(s + " ");
		    }		   
		    p.permutations.clear();
		    System.out.println();
 		}
	}

	public void findPermutations(String s) {
		int[] countArray = new int[26];
		populateCountArray(s, countArray);
		permute(new StringBuilder(), countArray, 0, s.length());		
		return;

	}

	public void permute(StringBuilder sFormed, int[] count, int currentLevel, int targetLevel) {
		if (currentLevel == targetLevel) {
			permutations.add(sFormed.toString());
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				sFormed.append((char)(i + 'A'));
				count[i]--;
				permute(sFormed, count, currentLevel + 1, targetLevel);
				count[i]++;
				sFormed.setLength(sFormed.length() - 1);
			}
		}
	}

	public void populateCountArray(String s, int[] countArray) {
		char[] cArray = s.toCharArray();
		for (char c : cArray) {
			countArray[c - 'A']++;
		}
	}
}