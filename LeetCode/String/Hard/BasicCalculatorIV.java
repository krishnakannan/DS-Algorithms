import java.util.*;
import java.lang.*;
import java.io.*;

class BasicCalculatorIV {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String expression = in.nextLine();
		int n = in.nextInt();
		String[] evalvars = new String[n];
		int[] evalints = new int[n];
		for (int i = 0; i < n; i++) {
			evalvars[i] = in.next();
			evalints[i] = in.nextInt();
		}
		BasicCalculatorIV bc4 = new BasicCalculatorIV();
		System.out.println(bc4.basicCalculatorIV(expression, evalvars, evalints));
	}

	class Expression {
		TreeMap<String, Integer> variables = new TreeMap<>();
		boolean isOpenBracket = false;
		boolean isCloseBracket = false;
		boolean isOperator = false;
		char operator = '@';
	}

	Map<String, Integer> evalSubstitution;

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        evalSubstitution = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
        	evalSubstitution.put(evalvars[i], evalints[i]);
        }
        StringBuilder sb = new StringBuilder(expression);        
        //System.out.println(sb.toString());
        balanceBrackets(sb);
        //System.out.println(sb.toString());
        expression = sb.toString();
        sb.setLength(0);
        for (int i = 0; i < expression.length(); i++) {
        	if (expression.charAt(i) == '(') {
        		sb.append("( ");
        	} else if (expression.charAt(i) == ')') {
        		sb.append(" )");
        	} else {
        		sb.append(expression.charAt(i));
        	}
        }
        
        List<Expression> substituted = substitute(sb.toString());
        Expression result = reduce(substituted);        

        return processOutput(result);
    }

    public List<String> processOutput(Expression resultExpression) {
    	List<String> finalResult = new ArrayList<>();
    	TreeMap<String, Integer> result = resultExpression.variables;
    	TreeMap<Integer, TreeMap<String, Integer>> degreeResults = new TreeMap<>(Collections.reverseOrder());
    	for (Map.Entry<String, Integer> entry : result.entrySet()) {
    		int degree = getDegree(entry.getKey());
    		if (!degreeResults.containsKey(degree)) {
    			degreeResults.put(degree, new TreeMap<>());
    		}
    		degreeResults.get(degree).put(entry.getKey(), entry.getValue());
    	}
    	
    	for (Map.Entry<Integer, TreeMap<String, Integer>> dEntry : degreeResults.entrySet()) {
    		for (Map.Entry<String, Integer> entry : dEntry.getValue().entrySet()) {
    			if (entry.getValue() != 0) {
                    if (dEntry.getKey() >= 0) {
                        finalResult.add("" + entry.getValue() + "*" + entry.getKey());	    
                    } else {
                        finalResult.add("" + entry.getValue() + "" + entry.getKey());	    
                    }
    				
    			}    			
    		}
    	}
    	return finalResult;

    }

    public int getDegree(String str) {
    	int degree = 0;
    	for (int i = 0; i < str.length(); i++) {
    		if (str.charAt(i) == '*') {
    			degree += 1;
    		}
    	}
    	return degree == 0 ? str.length() == 0 ? -1 : 0 : degree;
    }

    public void balanceBrackets(StringBuilder sb) {    	
    	for (int i = 0; i < sb.length(); i++) {
    		if (sb.charAt(i) == '*') {
    			int fwdBCount = 0;
    			int fIndex = i + 1;  
    			boolean fInserted = false;  			    			
    			while (fIndex < sb.length()) {
    				fIndex += 1;
    				//System.out.println("fIndex " + fIndex + " fwdBCount " + fwdBCount);
    				if (sb.charAt(fIndex) == '(') {
    					fwdBCount += 1;
    				} else if (sb.charAt(fIndex) == ')') {
    					fwdBCount -= 1;
    				}
    				if (fwdBCount == 0) {
    					while (fIndex < sb.length() && sb.charAt(fIndex) != ' ') {
    						fIndex++;
    					}
    					fIndex -= 1;
    					sb.insert(fIndex + 1, ")");
    					fInserted = true;
    					break;
    				}
    			} 
    			if (!fInserted) {
    				sb.append(")");
    			}
    			int revBCount = 0;
    			int rIndex = i - 1;
    			boolean rInserted = false;
    			while (rIndex >= 0) {
    				rIndex -= 1;
    				//System.out.println("rIndex " + rIndex + " revBCount " + revBCount );
    				if (sb.charAt(rIndex) == '(') {
    					revBCount -= 1;
    				} else if (sb.charAt(rIndex) == ')') {
    					revBCount += 1;
    				}
    				if (revBCount == 0) {
    					while (rIndex >= 0 && sb.charAt(rIndex) != ' ') {
    						rIndex--;
    					}
    					rIndex += 1;
    					sb.insert(rIndex, "(");
    					rInserted = true;
    					break;
    				}
    			}
    			if (!rInserted) {
    				sb.insert(0, "(");
    			}
    			i += 1;    			
    			//System.out.println("i " + i + " " + sb.toString());
    		}
    	}
    }

    public List<Expression> substitute(String expression) {
    	String[] expressionArray = expression.split(" ");
    	List<Expression> expressionsList = new ArrayList<>();
    	for (int i = 0; i < expressionArray.length; i++) {
    		if (evalSubstitution.containsKey(expressionArray[i])) {
    			expressionArray[i] = Integer.toString(evalSubstitution.get(expressionArray[i]));
    		}
    	}

    	for (int i = 0; i < expressionArray.length; i++) {
    		Expression expr = new Expression();
    		if (isNum(expressionArray[i])) {
    			int num = getInt(expressionArray[i]);
    			expr.variables.put("", num);
    		} else if (expressionArray[i].equals("(")) {
    			expr.isOpenBracket = true;
    		} else if (expressionArray[i].equals(")")) {
    			expr.isCloseBracket = true;
    		} else if (expressionArray[i].equals("+") || expressionArray[i].equals("-") || expressionArray[i].equals("*")) {
    			expr.isOperator = true;
    			expr.operator = expressionArray[i].charAt(0);
    		} else {
    			expr.variables.put(expressionArray[i], 1);
    		}
    		expressionsList.add(expr);
    	}
    	//System.out.println(Arrays.toString(expressionArray));
    	//print(expressionsList);
    	return expressionsList;
    }

    public Expression reduce(List<Expression> expressions) {
    	//print(expressions);
    	if (expressions.size() == 1) {
    		return expressions.get(0);
    	}

    	int start = 0;
    	int end = expressions.size();

    	Expression result = new Expression();
    	if (expressions.get(0).isOpenBracket) {
    		List<Expression> sublist = getSubList(expressions, 0);
    		result = reduce(sublist);
    		start += sublist.size() + 2;
    	} else {
    		result = expressions.get(0);
    		start += 1;
    	}

    	while (start < end) {
    		Expression oper = expressions.get(start);
    		start += 1;
    		Expression current = new Expression();
    		// printExpr(result);
    		// printExpr(oper);
    		
    		if (expressions.get(start).isOpenBracket) {
				List<Expression> sublist = getSubList(expressions, start);
				current = reduce(sublist);
				start += sublist.size() + 2;
			} else {
				current = expressions.get(start);
				start += 1;
			}

    		// printExpr(current);
    		if (oper.operator == '+') {
    			result = add(result, current);
    		} else if (oper.operator == '-') {
    			result = subtract(result, current);
    		} else if (oper.operator == '*') {
    			result = multiply(result, current);
    		}
    		
    	}

    	return result;
    }

    public List<Expression> getSubList(List<Expression> expressions, int start) {
    	List<Expression> newExpressions = new ArrayList<>();
    	int bCount = 1;
    	for (int i = start + 1; i < expressions.size(); i++) {
    		if (expressions.get(i).isOpenBracket) {
    			bCount += 1;
    		}
    		if (expressions.get(i).isCloseBracket) {
    			bCount -= 1;    			
    		}
    		if (bCount == 0) {
    			break;
    		}
    		newExpressions.add(expressions.get(i));
    	}
    	return newExpressions;
    }

    public Expression add(Expression one, Expression two) {
    	Expression result = new Expression();
    	for (Map.Entry<String, Integer> entry : one.variables.entrySet()) {
    		result.variables.put(entry.getKey(), result.variables.getOrDefault(entry.getKey(), 0) + entry.getValue());
    	}
    	for (Map.Entry<String, Integer> entry : two.variables.entrySet()) {
    		result.variables.put(entry.getKey(), result.variables.getOrDefault(entry.getKey(), 0) + entry.getValue());
    	}
    	return result;
    }

    public Expression subtract(Expression one, Expression two) {
    	Expression result = new Expression();
    	for (Map.Entry<String, Integer> entry : one.variables.entrySet()) {
    		result.variables.put(entry.getKey(), result.variables.getOrDefault(entry.getKey(), 0) + entry.getValue());
    	}
    	for (Map.Entry<String, Integer> entry : two.variables.entrySet()) {
    		result.variables.put(entry.getKey(), result.variables.getOrDefault(entry.getKey(), 0) - entry.getValue());
    	}
    	return result;
    }

    public Expression multiply(Expression one, Expression two) {
    	Expression result = new Expression();
    	
    	for (Map.Entry<String, Integer> oneEntry : one.variables.entrySet()) {
    		for (Map.Entry<String, Integer> twoEntry : two.variables.entrySet()) {
    			String mulVar = "";    			
    			if (oneEntry.getKey().equals("") && twoEntry.getKey().equals("")) {
    				mulVar = "";    				
    			} else if (!oneEntry.getKey().equals("") && twoEntry.getKey().equals("")) {
    				mulVar = oneEntry.getKey();
    			} else if (oneEntry.getKey().equals("") && !twoEntry.getKey().equals("")) {
    				mulVar = twoEntry.getKey();
    			} else {
    				String[] tempOne = oneEntry.getKey().split("\\*");
    				String[] tempTwo = twoEntry.getKey().split("\\*");
    				List<String> tempList = new ArrayList<>();
    				for (int i = 0; i < tempOne.length; i++) {
    					tempList.add(tempOne[i]);
    				}
    				for (int i = 0; i < tempTwo.length; i++) {
    					tempList.add(tempTwo[i]);
    				}
    				Collections.sort(tempList);
    				StringBuilder sb = new StringBuilder();
    				for (String str : tempList) {
    					sb.append(str + "*");
    				}
    				sb.setLength(sb.length() - 1);
    				mulVar = sb.toString();
    				
    			}
    			Integer mulVal = oneEntry.getValue() * twoEntry.getValue();
    			result.variables.put(mulVar, result.variables.getOrDefault(mulVar, 0) + mulVal);
    		}
    	}

    	return result;
    }

    public boolean isNum(String str) {
        if (str.length() <= 0) {
            return false;
        }
        int i = 0;
        if (str.length() > 0 && str.charAt(0) == '-') {
            i += 1;
        }
        if (i == str.length()) {
            return false;
        }
    	for (; i < str.length(); i++) {
    		if (str.charAt(i) < '0' || str.charAt(i) > '9') {
    			return false;
    		}
    	}
    	return true;
    }

    public int getInt(String str) {
    	int val = 0;
        int i = 0;
        boolean isNeg = false;
        if (str.charAt(0) == '-') {
            isNeg = true;
            i += 1;
        }
    	for (; i < str.length(); i++) {
    		val *= 10;
    		val += str.charAt(i) - '0';
    	}
    	return isNeg ? -val : val;
    }

    public void print(List<Expression> expressions) {
    	for (Expression expression : expressions) {
    		if (expression.isOperator) {
    			System.out.print(expression.operator + " ");
    		} else if (expression.isOpenBracket) {
    			System.out.print("( ");
    		} else if (expression.isCloseBracket) {
    			System.out.print(" )");
    		} else {
    			System.out.print(expression.variables + " ");
    		}    		    		
    	}
    	System.out.println();
    }

    public void printExpr(Expression expression) {
    	if (expression.isOperator) {
			System.out.print(expression.operator + " ");
		} else if (expression.isOpenBracket) {
			System.out.print("( ");
		} else if (expression.isCloseBracket) {
			System.out.print(" )");
		} else {
			System.out.print(expression.variables + " ");
		}
		System.out.println();
    }
}