import java.util.*;
import java.lang.*;
import java.io.*;

class ParseLispExpression {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String expression = in.nextLine();
		ParseLispExpression ple = new ParseLispExpression();
		System.out.println(ple.evaluate(expression));
	}

    public int evaluate(String expressionString) {

        String[] expression = preProcess(expressionString);               
        return eval(new ArrayList<>(), expression);
    }


    public int eval(List<Map<String, Integer>> higherScopeVars, String[] expression) {
    	//System.out.println(Arrays.toString(expression) + " " + higherScopeVars);
    	Map<String, Integer> currentScopeVars = new HashMap<>();

    	if (expression[0].equals("(")) {
    		String[] subExp = getSubExpression(expression, 0);
    		List<Map<String, Integer>> scopeVars = new ArrayList<>(higherScopeVars);
    		scopeVars.add(currentScopeVars);
    		return eval(scopeVars, subExp);
    	} else if (expression[0].equals("let")) {
    		int last = 0;

    		for (int i = 1; i < expression.length; i++) {    			
    			if (expression[i].equals("(")) {
    				List<Map<String, Integer>> scopeVars = new ArrayList<>(higherScopeVars);
    				scopeVars.add(currentScopeVars);
    				String[] subExp = getSubExpression(expression, i);
    				last = eval(scopeVars, subExp);
    				i += subExp.length + 1;
    			} else {
    				if (isNumber(expression[i])) {
    					last = getNumber(expression[i]);
    				} else {
    					String variable = expression[i];
    					if (i < expression.length - 1) {
    						int value = 0;
    						if (expression[i + 1].equals("(")) {
    							List<Map<String, Integer>> scopeVars = new ArrayList<>(higherScopeVars);
			    				scopeVars.add(currentScopeVars);
			    				String[] subExp = getSubExpression(expression, i + 1);
			    				value = eval(scopeVars, subExp);
			    				//System.out.println("EXP " + Arrays.toString(expression) + " SUBEXP " + Arrays.toString(subExp) + " => " + value);			    				
			    				currentScopeVars.put(variable, value);
			    				last = value;
			    				i += subExp.length + 1;
    						} else {    							
    							if (isNumber(expression[i + 1])) {
    								value = getNumber(expression[i + 1]);	
    							} else {
                                    
    								value = currentScopeVars.getOrDefault(expression[i + 1], 0);
    							}
    							last = value;
    							currentScopeVars.put(variable, value);
    						}
    					} else {
    						last = currentScopeVars.get(variable);
    					}
    				}
    			}
    		}

    		return last;

    	} else if (expression[0].equals("add")) { 
    		boolean firstFilled = false;
    		int firstOperand = 0;
    		int secondOperand = 0;
    		for (int i = 1; i < expression.length; i++) {    		
    			if (expression[i].equals("(")) {
    				List<Map<String, Integer>> scopeVars = new ArrayList<>(higherScopeVars);
    				scopeVars.add(currentScopeVars);
    				String[] subExp = getSubExpression(expression, i);
    				if (!firstFilled) {
    					firstOperand = eval(scopeVars, subExp);
    					firstFilled = true;
    				} else {
    					secondOperand = eval(scopeVars, subExp);
    				}
    				i += subExp.length + 1;
    			} else if (isNumber(expression[i])) {
    				if (!firstFilled) {
    					firstOperand = getNumber(expression[i]);
    					firstFilled = true;
    				} else {
    					secondOperand = getNumber(expression[i]);
    				}
    			} else {
    				String variable = expression[i];
    				if (currentScopeVars.containsKey(variable)) {
    					if (!firstFilled) {
	    					firstOperand = currentScopeVars.get(variable);
	    					firstFilled = true;
	    				} else {
	    					secondOperand = currentScopeVars.get(variable);
	    				}
    				} else {
    					for (int x = higherScopeVars.size() - 1; x >= 0; x--) {
    						if (higherScopeVars.get(x).containsKey(variable)) {
    							if (!firstFilled) {
			    					firstOperand = higherScopeVars.get(x).get(variable);
			    					firstFilled = true;
			    				} else {
			    					secondOperand = higherScopeVars.get(x).get(variable);
			    				}		
			    				break;
    						}
    					}
    				}
    			}
    		}

    		return firstOperand + secondOperand;

    	} else if (expression[0].equals("mult")) {
    		boolean firstFilled = false;
    		int firstOperand = 0;
    		int secondOperand = 0;
    		for (int i = 1; i < expression.length; i++) {    		
    			if (expression[i].equals("(")) {
    				List<Map<String, Integer>> scopeVars = new ArrayList<>(higherScopeVars);
    				scopeVars.add(currentScopeVars);
    				String[] subExp = getSubExpression(expression, i);
    				if (!firstFilled) {
    					firstOperand = eval(scopeVars, subExp);
    					firstFilled = true;
    				} else {
    					secondOperand = eval(scopeVars, subExp);
    				}
    				i += subExp.length + 1;
    			} else if (isNumber(expression[i])) {
    				if (!firstFilled) {
    					firstOperand = getNumber(expression[i]);
    					firstFilled = true;
    				} else {
    					secondOperand = getNumber(expression[i]);
    				}
    			} else {
    				String variable = expression[i];
    				if (currentScopeVars.containsKey(variable)) {
    					if (!firstFilled) {
	    					firstOperand = currentScopeVars.get(variable);
	    					firstFilled = true;
	    				} else {
	    					secondOperand = currentScopeVars.get(variable);
	    				}
    				} else {
    					for (int x = higherScopeVars.size() - 1; x >= 0; x--) {
    						if (higherScopeVars.get(x).containsKey(variable)) {
    							if (!firstFilled) {
			    					firstOperand = higherScopeVars.get(x).get(variable);
			    					firstFilled = true;
			    				} else {
			    					secondOperand = higherScopeVars.get(x).get(variable);
			    				}		
			    				break;
    						}
    					}
    				}
    			}
    		}
    		return firstOperand * secondOperand;
    	}
    	return 0;
    }


    public boolean isNumber(String val) {
    	return val.charAt(0) == '-' || (val.charAt(0) >= '0' && val.charAt(0) <= '9');
    }

    public int getNumber(String num) {
    	int val = 0;
    	boolean isNeg = false;
    	int index = 0;
    	if (num.charAt(0) == '-') {
    		isNeg = true;
    		index += 1;
    	}
    	while (index < num.length()) {
    		val *= 10;
    		val += num.charAt(index) - '0';
    		index += 1;
    	}
    	return isNeg ? -val : val;
    }

    public String[] getSubExpression(String[] expression, int startIndex) {
    	List<String> eList = new ArrayList<>();    	
    	int index = startIndex + 1;
    	int brackets = 1;
    	while (index < expression.length) {    		
    		if (expression[index].equals("(")) {
    			brackets += 1;
    		} else if (expression[index].equals(")")) {
    			brackets -= 1;
    		} 
    		if (brackets == 0) {
    			break;
    		}
    		eList.add(expression[index]);
    		index += 1;
    	}        	
    	return eList.toArray(new String[eList.size()]);
    }



    public String[] preProcess(String expression) {    	
    	expression = expression.replaceAll("\\(", "( ");
    	expression = expression.replaceAll("\\)", " )");
    	String[] expressionArray = expression.split(" ");
    	return expressionArray;
    }
}