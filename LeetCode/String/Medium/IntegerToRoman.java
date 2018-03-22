import java.util.*;
import java.lang.*;
import java.io.*;

class IntegerToRoman {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		IntegerToRoman itr = new IntegerToRoman();
		System.out.println(itr.intToRoman(num));
	}

	/*
		Usage of StringBuilder makes execution(runtime) slower.
	*/

	TreeMap<Integer, Character> romanMap;

    public String intToRoman(int num) {
        romanMap = new TreeMap<>();
        initializeMap();
        StringBuilder sBuilder = new StringBuilder();
        while (num > 0) {        	
        	int digits = getDigits(num);
        	int value = getWholeValue(num, digits - 1);
        	num -= value;
        	sBuilder.append(getRoman(value));
        }
        return sBuilder.toString();	
    }


    public String getRoman(int num) {
    	int tNum = num;
    	int rNum;
    	if (romanMap.containsKey(tNum)) {
    		rNum = tNum;
    	} else {
    		rNum = romanMap.lowerKey(num);
    	}

    	String rString = new String();
    	while (tNum > 0) {    		
    		if (tNum % rNum == 0) {
    			int mValue = tNum / rNum;
    			while (--mValue >= 0) {
    				rString = rString + romanMap.get(rNum);
    			}
    			tNum = 0;
    		} else {
                rString = rString + romanMap.get(rNum);    			
    			tNum -= rNum;
    			if (romanMap.containsKey(tNum)) {
		    		rNum = tNum;
		    	} else {
		    		rNum = romanMap.lowerKey(tNum);
		    	}
    		}
    	}

    	if (isValid(rString)) {
    		return rString;
    	}

    	tNum = num;
    	rNum = romanMap.higherKey(num);
    	int lVal = rNum - tNum;    	

    	return romanMap.get(lVal) +""+ romanMap.get(rNum);
    } 

    public boolean isValid(String generated) {
    	return generated.length() > 4 ? false : generated.length() == 4 ? 
    		generated.charAt(0) != generated.charAt(generated.length() - 1): true;
    }


    public int getWholeValue(int num, int exponent) {
    	int n = (int) Math.pow(10, exponent);
    	num /= n;
    	num *= n;
    	return num;
    }

    public int getDigits(int num) {
    	return (int) Math.log10(num) + 1;
    }

    public void initializeMap() {
    	romanMap.put(1, 'I');
    	romanMap.put(5, 'V');
    	romanMap.put(10, 'X');
    	romanMap.put(50, 'L');
    	romanMap.put(100, 'C');
    	romanMap.put(500, 'D');
    	romanMap.put(1000, 'M');
    }
}