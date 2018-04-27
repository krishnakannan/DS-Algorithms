import java.util.*;
import java.lang.*;
import java.io.*;

class RemoveInvalidParanthesis {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		RemoveInvalidParanthesis rip = new RemoveInvalidParanthesis();
		String s = in.next();
		System.out.println(rip.removeInvalidParentheses(s));
	}

    public List<String> removeInvalidParentheses(String string) {
        List<String> validParantheses = new ArrayList<>();

        Queue<String> bfsQ = new LinkedList<>();
        boolean foundLongestValid = false;
        int longestValidLength = -1;
        bfsQ.add(string);
        Set<String> processed = new HashSet<>();

        while (!bfsQ.isEmpty()) {
        	String polled = bfsQ.poll();
        	
        	if (isValid(polled)) {
        		foundLongestValid = true;        		
        		longestValidLength = polled.length();
        		validParantheses.add(polled);
        		break;
        	} else {
        		processed.add(polled);
        		int polledLength = polled.length();
        		for (int i = 0; i < polledLength; i++) {        			
        			String nextLevel = polled.substring(0, i) + polled.substring(i + 1, polledLength);
        			if (!processed.contains(nextLevel)) {
        				bfsQ.add(nextLevel);
        				processed.add(nextLevel);
        			}        			
        		}
        	}
        }

        if (foundLongestValid) {
        	while (!bfsQ.isEmpty()) {
        		String polled = bfsQ.poll();
        		if (polled.length() < longestValidLength) {
        			break;
        		} else {
        			if (isValid(polled)) {
        				validParantheses.add(polled);
        			}
        		}
        	}
        }

        return validParantheses;
    }

    public boolean isValid(String s) {
    	int length = s.length();
    	int openCount = 0;
    	int closeCount = 0;
    	for (int i = 0; i < length; i++) {
    		if (s.charAt(i) == ')') {
    			closeCount++;
    		} else if (s.charAt(i) == '(') {
    			openCount++;
    		}
    		if (closeCount > openCount) {
    			return false;
    		}
    	}
    	return openCount == closeCount;
    }
}