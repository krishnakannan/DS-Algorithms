import java.util.*;
import java.lang.*;
import java.io.*;


class AdditiveNumber {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		AdditiveNumber an = new AdditiveNumber();
		String num = in.next();
		System.out.println(an.isAdditiveNumber(num));
	}



    public boolean isAdditiveNumber(String num) {
    	char[] numArr = num.toCharArray();
    	if (num.length() < 3) {
            return false;
        }
		 
		 int fStart = 0;
		 int fEnd = fStart;
		 int sStart = fStart + 1;
		 int sEnd = sStart;

		 while (fEnd < numArr.length) {		 	
		 	long fValue = strToInt(numArr, fStart, fEnd);		 	
		 	if (numArr[fStart] == '0' && fEnd - fStart >= 1) {		 		
		 			break;
		 	}
		 	sStart = fEnd + 1;
			sEnd = sStart;				
		 	while (sEnd < numArr.length) {
		 		if (numArr[sStart] == '0' && sEnd - sStart >= 1) {
		 			break;
		 		}
		 		long sValue = strToInt(numArr, sStart, sEnd);
		 		boolean isAdditive = process(numArr, sEnd + 1, fValue, sValue);
		 		if (isAdditive) {		 			
		 			return isAdditive;
		 		}
		 		sEnd++;
		 	}
		 	fEnd++;
		 }		 
		 return false;
    }

    public boolean process(char[] num, int startIndex, long fValue, long sValue) {
    	long predictedNext = fValue + sValue;
    	int pDigits = getDigits(predictedNext);
    	int index = startIndex;
    	long actualNext = 0;
    	while (index < num.length) {
    		actualNext = strToInt(num, index, index + pDigits - 1);
    		//System.out.println("fValue " + fValue + " sValue " + sValue + " predictedNext " + predictedNext + "(" + pDigits + ")" + " actualNext " + actualNext);
    		if (predictedNext == actualNext) {
    			index += pDigits; 
    			if (index >= num.length) {
    				return true;
    			}
    			fValue = sValue;
    			sValue = actualNext;
    			predictedNext = fValue + sValue;    			
    			pDigits = getDigits(predictedNext);    			
    		} else {    			
    			return false;
    		}

    	}		    	
    	return false;
    }


    public int getDigits(long num) {    	
    	return num == 0 ? 1 : (int) (Math.log10(num) + 1);
    }

    public long strToInt(char[] num, int start, int end) {
    	long val = 0;
    	for (int i = start; i <= end && i < num.length; i++) {
    		val *= 10;
    		val += Character.getNumericValue(num[i]);    		
    	}
    	return val;
    }
}