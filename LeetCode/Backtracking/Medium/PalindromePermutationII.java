import java.util.*;
import java.lang.*;
import java.io.*;

class PalindromePermutationII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PalindromePermutationII pp = new PalindromePermutationII();
		String s = in.next();
		System.out.println(pp.generatePalindromes(s));
	}

	List<String> palindromes;
	int[] charMap = new int[128];
    public List<String> generatePalindromes(String s) {
        palindromes = new ArrayList<>();        
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
        	charMap[(int)s.charAt(i)]++;
        }
        int oddCount = 0;
        for (int i = 0; i < charMap.length; i++) {
            if (charMap[i] % 2 != 0) {
                oddCount++;
            }
        }
        
        if (oddCount > 1) {
            return palindromes;  
        } 
        generatePalindromes(new char[s.length()], 0, s.length() - 1);
        return palindromes;
    }

    public void generatePalindromes(char[] formedWord, int start, int end) {

    	if (start > end) {
    		palindromes.add(new String(formedWord));
    		return;
    	}

    	
    	for (int i = 0; i < charMap.length; i++) {
    		if (charMap[i] >= 2) {
    			charMap[i] -= 2;
    			formedWord[start] = (char) (i);
    			formedWord[end] = (char) (i);
    			generatePalindromes(formedWord, start + 1, end - 1);
    			formedWord[end] = Character.MIN_VALUE;
    			formedWord[start] = Character.MIN_VALUE;
    			charMap[i] += 2;
    		} else if (charMap[i] == 1 && start == end) {
    			charMap[i] -= 1;
    			formedWord[start] = (char) (i);
    			formedWord[end] = (char) (i);
    			generatePalindromes(formedWord, start + 1, end - 1);
    			formedWord[end] = Character.MIN_VALUE;
    			formedWord[start] = Character.MIN_VALUE;
    			charMap[i] += 1;
    		} 
    	}

    }
    
    
}