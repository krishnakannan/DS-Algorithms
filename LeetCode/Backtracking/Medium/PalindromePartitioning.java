import java.util.*;
import java.lang.*;
import java.io.*;

class PalindromePartitioning {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PalindromePartitioning pp = new PalindromePartitioning();
		String s = in.next();
		System.out.println(pp.partition(s));
	}


	List<List<String>> partitions = new ArrayList<>();

    public List<List<String>> partition(String s) {
    	char[] arr = s.toCharArray();
        partition(arr, 0, 0, new ArrayList<>());
        return partitions;
    }

    public void partition(char[] string, int startIndex, int currentIndex,
    		 List<String> currentStrList) {

    	if (currentIndex >= string.length - 1) {
    		if (currentIndex == string.length) {
    			partitions.add(new ArrayList<>(currentStrList));    			
    		} else if (isPalindrome(string, startIndex, currentIndex)) {
    			currentStrList.add(new String(string, startIndex, currentIndex - startIndex + 1));
    			partitions.add(new ArrayList<>(currentStrList));
    			currentStrList.remove(currentStrList.size() - 1);	    			
    		}
    		return;
    	}

    	for (int i = startIndex; i < string.length; i++) {    		    		
    		if (isPalindrome(string, startIndex, i)) {    			
    			currentStrList.add(new String(string, startIndex, i - startIndex + 1));
    			partition(string, i + 1, i + 1, currentStrList);    			
				currentStrList.remove(currentStrList.size() - 1);	
    		} 
    	}
    }


    public boolean isPalindrome(char[] string, int startIndex, int endIndex) {
    	while (startIndex <= endIndex) {
    		if (string[startIndex] == string[endIndex]) {
    			startIndex++;
    			endIndex--;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
}