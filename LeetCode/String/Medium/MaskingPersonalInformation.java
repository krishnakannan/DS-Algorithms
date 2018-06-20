import java.util.*;
import java.lang.*;
import java.io.*;

class MaskingPersonalInformation {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		MaskingPersonalInformation mpi = new MaskingPersonalInformation();
		System.out.println(mpi.maskPII(s));
	}

    public String maskPII(String s) {
    	char[] string = s.toCharArray();
     	if (isEmail(string)) {
     		return processEmail(string);
     	} else {
     		return processNumber(string);
     	}
    }

    public String processEmail(char[] string)  {
    	StringBuilder builder = new StringBuilder();
    	builder.append(Character.toLowerCase(string[0]));
    	builder.append("*****");
    	int i = 1;
    	for (; i < string.length - 1; i++) {
    		if (string[i + 1] == '@') {
    			builder.append(Character.toLowerCase(string[i]));
    			i += 1;
    			break;
    		}
    	}

    	for (; i < string.length; i++) {
    		builder.append(Character.toLowerCase(string[i]));
    	}

    	return builder.toString();
    }

    public String processNumber(char[] string) {
    	int count = numberOfDigits(string);
    	StringBuilder builder = new StringBuilder();
    	if (count == 10) {
    		builder.append("***-***-");
    	} else {    		
    		int diff = count - 10;
    		builder.append("+");
    		while (--diff >= 0) {
    			builder.append("*");
    		}
    		builder.append("-***-***-");
    	}

    	int numCount = 0;
		int index = string.length - 1;
		while (index >= 0) {			
			if (string[index] >= '0' && string[index] <= '9') {
				numCount += 1;
			}
			if (numCount == 4) {
				break;
			}
			index -= 1;
		}
		for (int i = index; i < string.length; i++) {
			if (string[i] >= '0' && string[i] <= '9') {
				builder.append(string[i]);
			}    			
		}

    	return builder.toString();
    }

    public int numberOfDigits(char[] string) {
    	int count = 0;
    	for (int i = 0; i < string.length; i++) {
    		if (string[i] >= '0' && string[i] <= '9') {
    			count += 1;
    		}
    	}
    	return count;
    }

    public boolean isEmail(char[] s) {
    	for (int i = 0; i < s.length; i++) {
    		if (s[i] == '@') {
    			return true;
    		}
    	}
    	return false;
    }
}