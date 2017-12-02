import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0


class RomanToInteger {

	Map<Character, Integer> charMap = new HashMap<>();

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		RomanToInteger rToi = new RomanToInteger();
		while (--testcases >= 0) {
		    String str = in.next();		
		    System.out.println(rToi.getInteger(str));
 		}
	}

	public int getInteger(String s) {
		initializeCharMap();
		char[] roman = s.toCharArray();
		int assuredValue = 0;
		int value = charMap.get(roman[0]);
		for (int i = 1; i < roman.length; i++) {			
			if (charMap.get(roman[i]) > charMap.get(roman[i - 1])) {				
				value = charMap.get(roman[i]) - value;
			} else {
				assuredValue += value;
				value = charMap.get(roman[i]);
			}			
		}
		assuredValue += value;			
		return assuredValue;
	}

	public void initializeCharMap() {
		charMap.put('I', 1);
		charMap.put('V', 5);
		charMap.put('X', 10);
		charMap.put('L', 50);
		charMap.put('C', 100);
		charMap.put('D', 500);
		charMap.put('M', 1000);
	}

}