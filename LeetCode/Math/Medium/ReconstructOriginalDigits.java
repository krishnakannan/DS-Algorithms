import java.util.*;
import java.lang.*;
import java.io.*;

class ReconstructOriginalDigits {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ReconstructOriginalDigits rod = new ReconstructOriginalDigits();
		String s = in.next();
		System.out.println(rod.originalDigits(s));

	}

	int[] sMap = new int[26];

    public String originalDigits(String s) {
 		
    	
    	int sLength = s.length();
    	int[] numberCount = new int[10];

    	for (int i = 0; i < sLength; i++) {
    		sMap[s.charAt(i) - 'a']++;
    	}

    	/*
			Extract Digits
    	*/

		//Extracting Even Numbers
		numberCount[0] = extract('z', new char[]{'z','e','r','o'});
		numberCount[2] = extract('w', new char[]{'t','w','o'});
		numberCount[4] = extract('u', new char[]{'f','o','u','r'});
		numberCount[6] = extract('x', new char[]{'s','i','x'});
		numberCount[8] = extract('g', new char[]{'e','i','g','h','t'});

		//Extracting Odd Numbers
		numberCount[1] = extract('o', new char[]{'o','n','e'});
		numberCount[3] = extract('t', new char[]{'t','h','r','e','e'});
		numberCount[5] = extract('f', new char[]{'f','i','v','e'});
		numberCount[7] = extract('s', new char[]{'s','e','v','e','n'});
		
		/*
			We are left with only 9 and we can use any character as unique
			I'll Use i because it occurs only one time;
		*/
		numberCount[9] = extract('i', new char[]{'n','i','n','e'});		

		StringBuilder sBuilder = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			int count = numberCount[i];
			//System.out.print(numberCount[i] + "  ");
			while (--count >= 0) {
				sBuilder.append(i);
			}
		}

		return sBuilder.toString();
    }

    public int extract(char unique, char[] number) {
    	int index = unique - 'a';
    	int count = sMap[index];

    	for (int i = 0; i < number.length; i++) {
    		int cIndex = number[i] - 'a';
    		sMap[cIndex] -= count;
    	}

    	return count;
    }
}