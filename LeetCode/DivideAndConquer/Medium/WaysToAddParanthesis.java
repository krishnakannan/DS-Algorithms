import java.util.*;
import java.lang.*;
import java.io.*;

class WaysToAddParanthesis {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		WaysToAddParanthesis wp = new WaysToAddParanthesis();
		System.out.println(wp.diffWaysToCompute(input));
	}

	List<Integer> values;

    public List<Integer> diffWaysToCompute(String inputString) {
        char[] input = inputString.toCharArray();
        values = new ArrayList<>();
        if (isNumber(input, 0, input.length - 1)) {
            int val = getValue(input, 0, input.length - 1);
            values.add(val);
            return values;
        }
        compute(input, 0, input.length - 1, true);
        return values;
    }



    public List<Integer> compute(char[] input, int startIndex, int endIndex, boolean topLevelRec) {
    	
    	if (isNumber(input, startIndex, endIndex)) {    		
    		int value = getValue(input, startIndex, endIndex);    		
    		//System.out.println("StIndex " + startIndex + " EndIndex " + endIndex + " VAl " + value);
    		List<Integer> list = new ArrayList<>();
    		list.add(value);
    		return list;
    	}

    	List<Integer> list = new ArrayList<>();    	

    	for (int i = startIndex; i <= endIndex; i++) {
    		if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
    			List<Integer> left = compute(input, startIndex, i - 1, false);
    			char operator = input[i];
    			List<Integer> right = compute(input, i + 1, endIndex, false);    		
    			//System.out.println(left + " " + operator + " " + right);
    			if (topLevelRec) {
    				for (Integer lValue : left) {
    					for (Integer rValue : right) {
    						values.add(calc(lValue, rValue, operator));
    					}
    				}
    			} else {
    				for (Integer lValue : left) {
    					for (Integer rValue : right) {
    						list.add(calc(lValue, rValue, operator));
    					}
    				}
    			}    			
    		}
    	}

    	return list;
    }

    public int calc(int left, int right, char operator) {
    	if (operator == '*') {
    		return left * right;
    	} else if (operator == '+') {
    		return left + right;
    	} else if (operator == '-') {
    		return left - right;
    	} else {
    		return 0;
    	}
    }

    public int getValue(char[] input, int startIndex, int endIndex) {
    	int val = 0;
    	for (int i = startIndex; i <= endIndex; i++) {
    		val *= 10;    		
    		val += Character.getNumericValue(input[i]);
    	}
    	return val;
    }

    public boolean isNumber(char[] input, int startIndex, int endIndex) {
    	boolean isNumber = true;
    	for (int i = startIndex; i <= endIndex; i++) {
    		if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
    			return !isNumber;
    		}
    	}
    	return isNumber;
    }
}