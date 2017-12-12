import java.util.*;
import java.lang.*;
import java.io.*;

//Copied
//https://leetcode.com/problems/valid-parenthesis-string/description/


public class ValidParenthesisString  {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);		
		ValidParenthesisString validParenthesisString = new ValidParenthesisString();		
		String str = in.next();		
 		System.out.println(validParenthesisString.checkValidString(str));
	}

    public boolean checkValidString(String s) {
    	int lo = 0, hi = 0;
	       for (char c: s.toCharArray()) {
	           lo += c == '(' ? 1 : -1;
	           hi += c != ')' ? 1 : -1;
	           if (hi < 0) break;
	           lo = Math.max(lo, 0);
	       }
	       return lo == 0;
    }

}

