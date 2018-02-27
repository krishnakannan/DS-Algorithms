import java.util.*;
import java.lang.*;
import java.io.*;

class MultiplyStrings {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String num1 = in.next();
		String num2 = in.next();
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply(num1, num2));
	}

    public String multiply(String num1, String num2) {
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        List<String> mulVals = new ArrayList<>();
        int tens = 0;
        for (int i = num2Arr.length - 1; i >= 0; i--) {
        	mulVals.add(multiply(num1Arr, num2Arr[i], tens));
        	tens++;
        }
//        System.out.println(mulVals);
        String value = add(mulVals);

        return value.charAt(0) == '0' ? "0" : value;
    }

    public String multiply(char[] num, char mValue, int tens) {
    	StringBuilder sBuilder = new StringBuilder();
    	
    	while (tens > 0) {    		
    		sBuilder.append('0');
    		tens--;
    	}

    	int carry = 0;
    	int mulValue = (int)mValue - '0';
    	for (int i = num.length - 1; i >= 0; i--) {
    		int val = ((int)(num[i] - '0') *  mulValue) + carry;    		
    		sBuilder.append(val % 10);
    		carry = val / 10;
    	}



    	if (carry > 0) {
    		String carryString = "";
	    	while (carry > 0) {	    		
	    		carryString = carryString + carry % 10;
	    		carry /= 10;
	    	}    
    		sBuilder.append(carryString);    		
    	}
    	

    	return sBuilder.toString();
    }

    public String add(List<String> values) {
    	StringBuilder sBuilder = new StringBuilder();
    	int carry = 0;
    	int maxLength = values.get(values.size() - 1).length();
    	for (int i = 0; i < maxLength; i++) {
    		int addValue = 0;
    		for (String value : values) {    			
    			if (i < value.length()) {
    				addValue += (int)(value.charAt(i) - '0');
    			}
    		}    		
    		addValue += carry;
    		sBuilder.append(addValue % 10);
    		carry = addValue / 10;
    	}

    	if (carry > 0) {
    		String carryString = "";
	    	while (carry > 0) {	    		
	    		carryString = carryString + carry % 10;
	    		carry /= 10;
	    	}    
    		sBuilder.append(carryString);    		
    	}

    	return sBuilder.reverse().toString();
    }
}