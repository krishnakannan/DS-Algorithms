import java.util.*;
import java.lang.*;
import java.io.*;

class GenerateParanthesis {

	public static void main(String atg[]) {
		Scanner in = new Scanner(System.in);
		GenerateParanthesis gp = new GenerateParanthesis();
		int n = in.nextInt();
		long startTime = System.nanoTime();
		System.out.println(gp.generateParenthesis(n));
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
	}

	List<String> bracketList = new ArrayList<>();

    public List<String> generateParenthesis(int n) {    	
        generate(n * 2, 0, n, n, new StringBuilder());        
        return bracketList;
    }

    public void generate(int targetLength, int currentLength, int open, int close, StringBuilder bracket) {
    	
    	if (currentLength == targetLength) {    		
    		bracketList.add(bracket.toString());    			 			
    	}

    	if (open > close) {
    		return;
    	}

    	if (open > 0) {
    		bracket.append("(");
    		generate(targetLength, currentLength + 1, open - 1, close, bracket);
    		bracket.setLength(bracket.length() - 1);
    	}
    	
    	if (close > 0) {
    		bracket.append(")");    		
    		generate(targetLength, currentLength + 1, open, close - 1, bracket);
    		bracket.setLength(bracket.length() - 1);
    	}
    }    
}


/*
	Exhaustive search - Works but very slow

	public void generate(int targetLength, int currentLength, int open, int close, StringBuilder bracket) {
    	
    	if (currentLength == targetLength) {
    		if (paranthesisChecker(bracket.toString())) {
    			bracketList.add(bracket.toString());    			
    		}    		
    	}

    	if (open > 0) {
    		bracket.append("(");
    		generate(targetLength, currentLength + 1, open - 1, close, bracket);
    		bracket.setLength(bracket.length() - 1);
    	}
    	
    	if (close > 0) {
    		bracket.append(")");
    		generate(targetLength, currentLength + 1, open, close - 1, bracket);
    		bracket.setLength(bracket.length() - 1);
    	}
    }

    public boolean paranthesisChecker(String bracket) {
    	char[] bArray = bracket.toCharArray();
    	Stack<Character> stack = new Stack<>();

    	for (int i = 0; i < bArray.length; i++) {
    		if (bArray[i] == '(') {
    			stack.push(bArray[i]);
    		} else if (!stack.empty() && stack.peek().equals('(') && bArray[i] == ')') {
    			stack.pop();
    		} else {
    			stack.push(bArray[i]);
    		}
    	}
    	return stack.empty();
    }

*/