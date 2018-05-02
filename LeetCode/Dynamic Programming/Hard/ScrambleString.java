import java.util.*;
import java.lang.*;   
import java.io.*;

class ScrambleString {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble(s1, s2));
	}

     boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        
        int[] alphabetCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alphabetCount[s1.charAt(i) - 'a']++;
            alphabetCount[s2.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] != 0) {
                return false;
            }
        }
        
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
                && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }    
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) 
               && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        
        
        return false;
    }
}
}