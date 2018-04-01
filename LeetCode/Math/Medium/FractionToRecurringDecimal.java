import java.util.*;
import java.lang.*;
import java.io.*;

class FractionToRecurringDecimal {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		FractionToRecurringDecimal ftrd = new FractionToRecurringDecimal();
		System.out.println(ftrd.fractionToDecimal(n, d));
	}


	Map<Long, Long> remMap;
	Map<Long, Long> qMap;
	boolean hasFoundRepeat = false;
	int repeatPos = 0;
	public String fractionToDecimal(int n, int d) {
        long numerator = (long)n;
        long denominator = (long)d;
        boolean isNegative = false;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            numerator = numerator < 0 ? -numerator : numerator;
            denominator = denominator < 0 ? -denominator : denominator;
            isNegative = true;
        } else if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
		String finalString = "";
		long lhs = numerator / denominator;
		remMap = new HashMap<>();
		qMap = new HashMap<>();
		
		String rhs = getFraction((numerator % denominator), denominator);

		if (hasFoundRepeat) {
            finalString = lhs + "." + rhs.substring(0, repeatPos) + "(" + rhs.substring(repeatPos, rhs.length()) + ")";			
			//finalString = lhs + ".(" + rhs + ")";
		} else {
			if (rhs.isEmpty()) {
				finalString = lhs + "";
			} else {
				finalString = lhs + "." + rhs;
			}
		}
		

		return isNegative ? "-" + finalString : finalString;
	}
	
	public String getFraction(long rem, long denominator) {        
		long position = -1l;
		String value = "";
		while (!hasFoundRepeat && rem > 0) {
			rem *= 10;
			long quotient = rem / denominator;            
			if (remMap.containsKey(rem) && qMap.get(remMap.get(rem)) == quotient) {
				hasFoundRepeat = true;
                repeatPos = remMap.get(rem).intValue();
				break;
			}            
			position++;
			if (denominator > rem) {
				remMap.put(rem, position);
				qMap.put(position, 0l);
				value = value + "0";
				continue;
			}             
			remMap.put(rem, position);
			qMap.put(position, quotient);            
			rem = rem % denominator;            
			value = value + "" + quotient;

		}
		
		return value;
	}
}