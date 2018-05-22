import java.util.*;
import java.lang.*;
import java.io.*;

class NumberOfAtoms {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String formula = in.next();
		NumberOfAtoms noa = new NumberOfAtoms();
		System.out.println(noa.countOfAtoms(formula));
	}

	class Token {
		String element;
		int count;
		public Token(String element, int count) {
			this.count = count;
			this.element = element;
		}
	}

    public String countOfAtoms(String formulaString) {
    	TreeMap<String, Integer> map = count(tokenize(formulaString), 1);
    	StringBuilder builder = new StringBuilder();
    	for (Map.Entry<String, Integer> entry : map.entrySet()) {
    		builder.append(entry.getKey());
            if (entry.getValue() != 1) {
                builder.append(entry.getValue());
            }
    	}    	
    	return builder.toString();
        
    }

    public TreeMap<String, Integer> count(List<String> formula, int mValue) {    	
    	//End Case
    	if (!formula.contains("(")) {
    		TreeMap<String, Integer> map = new TreeMap<>();
    		for (String fStr : formula) {
    			Token token = getToken(fStr);
    			if (map.containsKey(token.element)) {
    				map.put(token.element, map.get(token.element) + (mValue * token.count));
    			} else {
    				map.put(token.element, (mValue * token.count));
    			}
    		}    		
    		return map;
    	}

    	TreeMap<String, Integer> map = new TreeMap<>();
    	int size = formula.size();
    	for (int i = 0; i < size; ) {
    		if (formula.get(i).equals("(")) {
    			int brackets = 1;
    			int tempIndex = i + 1;
    			while (tempIndex < size && brackets != 0) {
    				if (formula.get(tempIndex).equals("(")) {
    					brackets += 1;
    				} else if (formula.get(tempIndex).equals(")")) {
    					brackets -= 1;
    				}
    				tempIndex += 1;
    			}
    			List<String> newList = subList(formula, i + 1, tempIndex - 1);
    			int newMValue = 1;
    			if (tempIndex < size && formula.get(tempIndex).charAt(0) >= '0' && formula.get(tempIndex).charAt(0) <= '9') {
    				newMValue = getNum(formula.get(tempIndex), 0, formula.get(tempIndex).length());
    				i = tempIndex + 1;
    			} else {
    				i = tempIndex;
    			}
    			TreeMap<String, Integer> newMap = count(newList, newMValue);
    			for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
    				if (map.containsKey(entry.getKey())) {
	    				map.put(entry.getKey(), map.get(entry.getKey()) + (mValue * entry.getValue()));
	    			} else {
	    				map.put(entry.getKey(), (mValue * entry.getValue()));
	    			}
    			}    			
    		} else {
    			Token token = getToken(formula.get(i));
    			if (map.containsKey(token.element)) {
    				map.put(token.element, map.get(token.element) + (mValue * token.count));
    			} else {
    				map.put(token.element, (mValue * token.count));
    			}
    			i += 1;
    		}
    	}    	
    	return map;

    }

    public List<String> subList(List<String> list, int start, int end) {
    	List<String> newList = new ArrayList<>();
    	for (int i = start; i < end; i++) {
    		newList.add(list.get(i));
    	}
    	return newList;
    }

    public Token getToken(String str) {
    	int nStart = 0;
    	while (nStart < str.length() && (str.charAt(nStart) < '0' || str.charAt(nStart) > '9')) {
    		nStart += 1;
    	}
    	String tokenString = str.substring(0, nStart);
    	int tokenVal = getNum(str, nStart, str.length());
    	return new Token(tokenString, tokenVal);
    }



    public List<String> tokenize(String formulaStr) {
    	char[] formula = formulaStr.toCharArray();
    	List<String> tokens = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	int index = 0;
    	while (index < formula.length) {    		
    		if ((formula[index] >= 'A' && formula[index] <= 'Z') || formula[index] == '(' || formula[index] == ')') {
    			if (formula[index] == '(' || formula[index] == ')') {
    				if (sb.length() != 0) {
    					tokens.add(sb.toString());	
    				}
    				sb.setLength(0);
    				tokens.add("" + formula[index]);
    				index += 1;
    				continue;
    			}
    			if (sb.length() != 0) {
    				tokens.add(sb.toString());
    				sb.setLength(0);
    			} 
    			sb.append(formula[index]);
    		} else {
    			sb.append(formula[index]);
    		}
    		index += 1;
    	}
    	if (sb.length() != 0) {
    		tokens.add(sb.toString());	
    	}
    	return tokens;
    }


    public int getNum(String str, int start, int end) {    	
    	int val = 0;
    	while (start < end) {
    		val *= 10;
    		val += str.charAt(start) - '0';
    		start += 1;
    	}
    	return val == 0 ? 1 : val;
    }
}