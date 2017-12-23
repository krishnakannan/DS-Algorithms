import java.util.*;
import java.lang.*;
import java.io.*;


class WordPatternII {

	public static void main(String args[]) {
		WordPatternII wp = new WordPatternII();
		Scanner in = new Scanner(System.in);
		String pattern = in.next();
		String str = in.next();
		long startTime = System.nanoTime();
		System.out.println(wp.wordPatternMatch(pattern, str));
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
	}
	
	boolean matchFound = false;

	public boolean wordPatternMatch(String pattern, String str) { 
		//pattern = removeAdjacentDuplicates(pattern);
		if (pattern.length() > str.length()) {
			return false;
		}
		String nStr = removeAdjacentDuplicates(str);        
		if (pattern.equals(nStr)) {
			return true && checkPatternAftRemovingAdjDuplicates(pattern,str);
		}
		//str = removeAdjacentDuplicates(str);
		if (pattern.isEmpty() && str.isEmpty()) {
			return true;
		} else if (pattern.isEmpty() || str.isEmpty()) {
			return false;
		} else if (pattern.equals(str)) {
			return true;
		} 
		match(pattern.toCharArray(), str.toCharArray(), new String[pattern.length()], 0, 0, 0, pattern.length());
		return matchFound;
	}

	public void match(char[] pattern, char[] string, String[] stringArr, int sIndex, 
		int strIndex, int noOfSplits, int targetSplit) {
		if (matchFound) {
			return;
		}
		
		//End Condition
		if (noOfSplits == targetSplit) {
			if (isValidSplit(pattern, stringArr)) {    					    	
				matchFound = true;
				return;
			} else {
				return;
			}
		}

		StringBuilder sBuilder = new StringBuilder();
		for (int i = sIndex; i < string.length; i++) {    		
			if (targetSplit - noOfSplits == 1) {
				sBuilder.append(new String(string, sIndex, (string.length - sIndex)));	    		    			
			} else {
				sBuilder.append(new String(string, sIndex, i - sIndex + 1));	    			
			}    		
			stringArr[strIndex] = sBuilder.toString();
			match(pattern, string, stringArr, i + 1, strIndex + 1, noOfSplits + 1, targetSplit);    		
			stringArr[strIndex] = "";
			if (targetSplit - noOfSplits == 1) {
				sBuilder.setLength(sBuilder.length() - (string.length  - sIndex));	
			} else {
				sBuilder.setLength(sBuilder.length() - (i - sIndex + 1));
			}
		}
		return;
	}




	//Bijenction Mapping and checker. 
	//Code from Word Pattern (Easy) Leetcode soln
	public boolean isValidSplit(char[] pattern, String[] strArr) {                
		if (strArr.length != pattern.length) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		Map<String, Character> revMap = new HashMap<>();
		for (int i = 0; i < pattern.length; i++) {
			if (map.containsKey(pattern[i])) {
				if (!map.get(pattern[i]).equals(strArr[i])) {
					return false;
				}
				continue;
			} 
			
			if (revMap.containsKey(strArr[i])) {
				if (!revMap.get(strArr[i]).equals(pattern[i])) {
					return false;
				}
				continue;
			}
			map.put(pattern[i], strArr[i]);
			revMap.put(strArr[i], pattern[i]);
		}
		return true;   
	}

	//Optimizations

	public String removeAdjacentDuplicates(String str) {
		char[] sArray = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < sArray.length; i++) {
			if (stack.empty()) {
				stack.push(sArray[i]);		
			} else {
				if (stack.peek() != sArray[i]) {
					stack.push(sArray[i]);
				}
			}    		
		}

		StringBuilder sBuilder = new StringBuilder();
		while (!stack.empty()) {
			sBuilder.append(stack.pop());
		}
		if (sBuilder.length() == 1) {
			return str;
		}        
		return sBuilder.reverse().toString();
	}

	public boolean checkPatternAftRemovingAdjDuplicates(String pattern, String string) {
		int pIndex = 0;
		int sIndex = 0;
		char[] sArr = string.toCharArray();
		char[] pArr = pattern.toCharArray();
		Map<Character, String> mapping = new HashMap<>();    	
		while (pIndex < pArr.length) {
			StringBuilder sBuilder = new StringBuilder();
			int i = sIndex;
			while (i < sArr.length - 1) {
				sBuilder.append(sArr[i]);
				if (sArr[i] == sArr[i + 1]){
					i++;
				} else {
					break;
				}
			}    		
			if (mapping.containsKey(pArr[pIndex]) && sBuilder.length() > 0){
				if (!mapping.get(pArr[pIndex]).equals(sBuilder.toString())) {    				
					return false;
				}   			
			} else {
				mapping.put(pArr[pIndex], sBuilder.toString());
			}

			sIndex = i + 1;
			pIndex++;
		}
		return true;
	}
}