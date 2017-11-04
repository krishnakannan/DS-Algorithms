import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/special-keyboard/0

class SpecialKeyboard {
	public static void main (String[] args) {
		SpecialKeyboard sk = new SpecialKeyboard();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();		    		   
			System.out.println(sk.calcMaxA(n));
 		}
	}

	public int calcMaxA(int n) {
		if (n <= 6) {
			return n;
		}

		int[] arr = new int[n + 1];
		for (int i = 1; i < 6; i++) {
			arr[i] = i;  
		}

		int paste = 1;		
		int max = 0;
		for (int i = 7; i <= n; i++) {
			paste = 1;
			for (int j = i - 3; j >= 1; j--) {
				int val = arr[j] + (paste * arr[j]);	
				max = max < val ? val : max;
				paste++;
			}
			arr[i] = max;
		}

		return max;
	}
}