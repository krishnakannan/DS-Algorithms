import java.util.*;
import java.lang.*;
import java.io.*;


public class ReverseWords {

	public static void main(String args[]) {
		ReverseWords rw = new ReverseWords();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
			in.nextLine();			
		    String str = in.nextLine();	
		    System.out.println(rw.reverseWords(str));
 		}
	}

    public String reverseWords(String s) {
    	String newString = s.trim();
    	String[] str = newString.split(" ");    	
    	reverse(str, 0, str.length - 1);
    	StringBuilder sBuilder = new StringBuilder();
    	for (String string : str) {
    		if (string != null && !string.isEmpty() && !string.equals(" ")) {
    			sBuilder.append(string);
    			sBuilder.append(" ");	
    		}    		
    	}
    	if (sBuilder.length() > 0) {
            sBuilder.setLength(sBuilder.length() - 1);    
        }   
    	return sBuilder.toString();
    }

    public void reverse(String[] str, int left, int right) {
    	while (left <= right) {
    		swap(str, left, right);
    		left++;
    		right--;
    	}
    }

    public void swap(String[] str, int p1, int p2) {
    	String temp = str[p1];
    	str[p1] = str[p2];
    	str[p2] = temp;
    }
}