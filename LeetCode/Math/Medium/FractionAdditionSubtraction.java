class Solution {

	List<Integer> numerators = new ArrayList<>();
	List<Integer> denominators = new ArrayList<>();	
	int index = 0;
    public String fractionAddition(String expression) {
    	char[] expressionArray = expression.toCharArray();
        parseExpression(expressionArray);

        if (numerators.size() == 0) {
        	return "";
        }

        int lcm = denominators.get(0);        
        int fractions = denominators.size();
        int finalNumerator = 0;

        for (int i = 1; i < fractions; i++) {
        	lcm = lcm(denominators.get(i), lcm);
        }

        for (int i = 0; i < fractions; i++) {
        	int factor = lcm / denominators.get(i);
        	finalNumerator += (numerators.get(i) * factor);
        }

        int[] reducedVal = new int[]{finalNumerator, lcm};
        reduce(reducedVal);

        return reducedVal[0] + "/" + reducedVal[1];
    }    

    public void reduce(int[] finalExpression) {
        boolean isNegative = finalExpression[0] < 0 ? true : false;
        
    	int numerator = finalExpression[0] < 0 ? -finalExpression[0] : finalExpression[0];
    	int denominator = finalExpression[1];

    	if (numerator == 0) {
    		finalExpression[1] = 1;
    		return;
    	}

    	int gcd = gcd(numerator, denominator);
    	numerator /= gcd;
    	denominator /= gcd;

    	finalExpression[0] = isNegative ? -numerator : numerator;
    	finalExpression[1] = denominator;

    }

    public void parseExpression(char[] expression) {
    	while (index < expression.length - 1) {
    		numerators.add(getNumerator(expression));
    		denominators.add(getDenominator(expression));            
    	}
    }

    public int getNumerator(char[] expression) {
    	boolean isNegative = false;
    	if (expression[index] == '-') {
    		isNegative = true;
    		index++;
    	} else if (expression[index] == '+') {
    		index++;
    	}
    	
    	int val = 0;

    	while (index < expression.length && expression[index] != '/') {
    		val = val * 10;
    		val = val + (expression[index] - '0');
    		index++;
    	}
    	index++;    
    	return isNegative ? -val : val;
    }

    public int getDenominator(char[] expression) {
    	int val = 0;

    	while (index < expression.length && expression[index] != '-' && expression[index] != '+') {
    		val = val * 10;
    		val = val + (expression[index] - '0');
    		index++;
    	}        
    	return val;
    }


    public int lcm(int a, int b) {
	    return a * (b / gcd(a, b));
	}

	//Euclids Algorithm
    public int gcd(int a, int b) {
	    if (b == 0) {
	    	return a;
	    }
	    else {
	    	return gcd(b, a % b);
	    }
	}
}