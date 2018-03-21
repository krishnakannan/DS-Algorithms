import java.util.*;
import java.lang.*;
import java.io.*;

class SolveTheEquation {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String equn = in.next();
		SolveTheEquation ste = new SolveTheEquation();
		System.out.println(ste.solveEquation(equn));
	}

	//Left, Right X Values
	int lxCount = 0;
	int rxCount = 0;

	//Left, Right Constant Values
	int lcCount = 0;
	int rcCount = 0;

    public String solveEquation(String equation) {
        String[] equations = equation.split("=");        
        processString(equations[0], true);
        processString(equations[1], false);

        // System.out.println("Left X " + lxCount + " Left Constant " + lcCount);
        // System.out.println("Right X " + rxCount + " Right Constant " + rcCount);

        if (lxCount == rxCount) {
        	if (lcCount == rcCount) {
        		return "Infinite solutions";
        	} else {
        		return "No solution";
        	}
        } 

        int totalXCount = lxCount - rxCount;
        int totalConstant = rcCount - lcCount;

        int finalX = totalConstant / totalXCount;

        return "x=" + finalX;

    }

    public void processString(String equation, boolean isLeft) {
    	int left = 0;
    	int right = left + 1;
    	int eLength = equation.length();
    	while (right < eLength) {
    		if (equation.charAt(right) == '+' || equation.charAt(right) == '-') {
    			processValue(equation.substring(left, right), isLeft);
    			left = right;
    			right = left + 1;
    		} else {
    			right++;
    		}
    	}
    	processValue(equation.substring(left, right), isLeft);
    }

    public void processValue(String str, boolean isLeft) {
    	// System.out.println("Processing " + str);
    	boolean isX = str.charAt(str.length() - 1) == 'x';

    	if (isX) {
    		str = str.substring(0, str.length());
    	}
    	boolean isNegative = false;
    	int value = 0;
    	int strlen = str.length();
    	int i = 0;
    	
    	if (str.charAt(0) == '+') {
    		i++;
    	} else if (str.charAt(0) == '-') {
    		i++;
    		isNegative = true;
    	}

        if (strlen == 1 && str.charAt(0) == 'x') {
            value =  1;
        } else {
            for (; i < strlen; i++) {    		
                if (str.charAt(i) == 'x') {
                    value = value == 0 && (str.charAt(0) != '0' && str.charAt(1) != '0')  ?  1 : value;
                    continue;
                }
                value *= 10;
                value += str.charAt(i) - '0';
    	    }    
        }
        
    	

    	if (isX) {
    		if (isLeft) {
    			lxCount += isNegative ? -value : value;
    		} else {
    			rxCount += isNegative ? -value : value;
    		}
    	} else {
    		if (isLeft) {
    			lcCount += isNegative ? -value : value;
    		} else {
    			rcCount += isNegative ? -value : value;
    		}
    	}

    }
}