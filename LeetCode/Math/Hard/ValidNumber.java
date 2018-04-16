import java.util.*;
import java.lang.*;
import java.io.*;

class ValidNumber {

	/*
		Observations
		
		1. Left Trim and Right Trim the String
		2. There should not be any spaces in between
		3. Exponent is supported (Multiple Exponent is not supported)
		4. Decimal points are supported;
		5. Negatives are supported
		6. + and - are allowed at start and after exponent

		7. Hex, Complex Numbers, Constants, Factorial - not numbers
		8. Operators and Expressions are not supported

	*/

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		ValidNumber vn = new ValidNumber();
		while (!s.equals("exit")) {
			System.out.println(vn.isNumber(s));
			s = in.next();
		}
		
		
	}

    public boolean isNumber(String s) {        
    	int decimalPoints = 0;
		int exponent = 0;
		int plusMinusSign = 0;
		int numberCount = 0;
     	s = s.trim();   
        if (s.isEmpty()) {
            return false;
        }
     	char[] string = s.toCharArray();
     	for (int i = 0; i < string.length; i++) {
     		//System.out.println("Decimal " + decimalPoints + " Exponent " + exponent + " plusMinusSign " + plusMinusSign);
     		if (decimalPoints > 1) {
     			return false;
     		}
     		if (plusMinusSign > 1) {
     			return false;
     		}
     		if (exponent > 1) {
     			return false;
     		}
     		if (string[i] < '0' || string[i] > '9')  {
     			if (string[i] == '+') {
     				if (exponent == 0 && i > 0) {
     					return false;
     				}
     				plusMinusSign++;
     			} else if (string[i] == '-') {
                    if (exponent == 0 && i > 0) {
     					return false;
     				}
     				plusMinusSign++;
     			} else if (string[i] == 'e') {
     				if (numberCount == 0) {
     					return false;
     				}
     				exponent++;
     				plusMinusSign = plusMinusSign == 0 ? 0 : plusMinusSign - 1;
     				decimalPoints = decimalPoints == 0 ? 0 : decimalPoints - 1;
     			} else if (string[i] == '.') {
                    if (exponent > 0 || decimalPoints > 0) {
     					return false;
     				}
     				decimalPoints++;
     			} else {
     				return false;
     			}
     		} else {
     			numberCount++;
     		}
     	}
     	if (string[string.length - 1] == '+' || string[string.length - 1] == '-' || string[string.length - 1] == 'e') {
     		return false;
     	}
     	return numberCount == 0 ? false : true;
    }

}