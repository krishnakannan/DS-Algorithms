import java.util.*;
import java.lang.*;   
import java.io.*;

class EncodeStringWithShortestLength {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		EncodeStringWithShortestLength eswsl = new EncodeStringWithShortestLength();
		System.out.println(eswsl.encode(s));		
	}

	Map<String, String> map;
    public String encode(String s) {
        map = new HashMap<>();
        getBestEncodedString(s);
        return map.containsKey(s) ? map.get(s) : " NOPE ";
    }

    public String getBestEncodedString(String s) {    	
    	if (map.containsKey(s)) {
    		return map.get(s);
    	}
    	int length = s.length();
    	if (length == 1) {
    		map.put(s, s);
    		return map.get(s);	
    	}
    	String smallestEncoding = s;
    	for (int i = 1; i < length; i++) {
    		String originalfHalf = getBestEncodedString(s.substring(0, i));
        	String originalsHalf = getBestEncodedString(s.substring(i));
        	String fHalf = originalfHalf;
        	String sHalf = originalsHalf;
        	if (originalfHalf.length() <= 3) {
        		fHalf = getEdgesEncoded(originalfHalf);
        	}
        	if (originalsHalf.length() <= 3) {
        		sHalf = getEdgesEncoded(originalsHalf);
        	}        	
        	String encode = "";        	
        	if (getEncodedContent(fHalf).equals(getEncodedContent(sHalf))) {
        		int num1 = getNum(fHalf);
        		int num2 = getNum(sHalf);     
        		if (fHalf.equals(sHalf) && fHalf.charAt(fHalf.length() - 1) == ']') {
        			encode = (num1 + num2) + "[" + getEncodedContent(fHalf) + "]";        			
        		} else if (fHalf.equals(sHalf)){        			
        			encode = "2[" + fHalf + "]";
        		} else {
        			encode = fHalf + sHalf;
        		}
        		
        	} else {
        		encode = originalfHalf + originalsHalf;
        	}        	
        	if (smallestEncoding.length() >= encode.length()) {        		
        		smallestEncoding = encode;
        	}
    	}

    	String selfEncoded = s;
    	Map<String, Integer> encodedValues = new HashMap<>();    	
    	for (int i = 1; i <= (length / 2) + 1; i++) {
    		String subStr = s.substring(0, i);
    		int subLength = subStr.length();    	
    		int j = i;
    		for (; j + subLength <= length; j += subLength) {
    			String subStrPattern = s.substring(j, j + subLength);
    			if (subStrPattern.equals(subStr)) {
    				encodedValues.put(subStr, encodedValues.getOrDefault(subStr, 1) + 1);
    			} else {
    				break;
    			}
    		}
    		
    	}
    	for (Map.Entry<String, Integer> encodedValueEntry : encodedValues.entrySet()) {
    		int formedLength = encodedValueEntry.getValue() * encodedValueEntry.getKey().length();
    		String encoded = "";
    		if (formedLength < length) {
    			encoded = encodedValueEntry.getValue() + "[" + encodedValueEntry.getKey() + "]" + s.substring(formedLength);
    		} else  {    			
    		 	encoded = encodedValueEntry.getValue() + "[" + encodedValueEntry.getKey() + "]";
    		}
    		if (encoded.length() < selfEncoded.length()) {
    			selfEncoded = encoded;
    		}
    	}    	
    	if (smallestEncoding.length() >= selfEncoded.length()) {        	
        		smallestEncoding = selfEncoded;
        	}

    	map.put(s, smallestEncoding);
    	return map.get(s);

    }

    public int getStartOfEncoded(String encoded) {
    	int index = 0;
    	while (index < encoded.length() && encoded.charAt(index) >= '0' && encoded.charAt(index) <= '9') {    		
    		index += 1;
    	}
    	return index;
    }

    public int getNum(String encoded) {
    	int val = 0;
    	int index = 0;
    	while (index < encoded.length() && encoded.charAt(index) >= '0' && encoded.charAt(index) <= '9') {
    		val *= 10;
    		val +=  encoded.charAt(index) - '0';
    		index += 1;
    	}
    	return val == 0 ? 1 : val;
    }

    public String getEdgesEncoded(String cleartext) {
    	boolean sameChar = true;
    	for (int i = 1; i < cleartext.length(); i++) {
    		if (cleartext.charAt(i) != cleartext.charAt(i - 1)) {
    			sameChar = false;
    			break;
    		}
    	}
    	if (sameChar) {
    		return cleartext.length() + "["+ cleartext.charAt(0) +"]";
    	}
    	return cleartext;
    }

    public String getEncodedContent(String encoded) {    	
    	int index = 0;
    	while (index < encoded.length() && encoded.charAt(index) >= '0' && encoded.charAt(index) <= '9') {
    		index++;
    	}    	
    	if (index == 0) {
    		return encoded;
    	} else {
    		if (encoded.charAt(encoded.length() - 1) == ']') {
    			return encoded.substring(index + 1, encoded.length() - 1);
    		} else {
    			return encoded.substring(index + 1);
    		}
    	}
    }
    
}