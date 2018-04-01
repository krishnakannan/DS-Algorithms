public class Solution {
    Map<Integer, Character> hexMap;
	Map<Character, Integer> revHexMap;

	public String toHex(int num) {
       hexMap = new HashMap<>();
       hexMap.put(10, 'a');
       hexMap.put(11, 'b');
       hexMap.put(12, 'c');
       hexMap.put(13, 'd');
       hexMap.put(14, 'e');
       hexMap.put(15, 'f');

       revHexMap = new HashMap<>();
       revHexMap.put('a', 10);
       revHexMap.put('b', 11);
       revHexMap.put('c', 12);
       revHexMap.put('d', 13);
       revHexMap.put('e', 14);
       revHexMap.put('f', 15);

       if (num > 0) {
    	return hexBuilder(num);
       } else if (num == 0) {
       	return "0";
       } else if (num == Integer.MIN_VALUE) {
       	return "80000000";
       } else {
       	return twosComplement(num);
       }
       
    }
    private String hexBuilder (int num) {
    	StringBuilder hBuilder = new StringBuilder();
       	while (num > 0) {
       		int temp = num % 16;
       		hBuilder.append(temp > 9 ? hexMap.get(temp) : Integer.toString(temp));
       		num /= 16;
       	}
		return hBuilder.reverse().toString();
    }

    private String twosComplement(int num) {
    	char[] hex = {'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f'};
    	String hexNumber = hexBuilder(Math.abs(num));
    	StringBuilder temp = new StringBuilder();
    	StringBuilder complement = new StringBuilder();
    	int carry = 0;
    	for (int i = 0; i < (8 - hexNumber.length()); i++) {
    		temp.append('0');
    	}
    	temp.append(hexNumber);

    	String cString = temp.toString();
    	//One's Complement
    	for (int i = 7; i >= 0; i--) {
    		int val = revHexMap.containsKey(cString.charAt(i)) ? revHexMap.get(cString.charAt(i)) : Character.getNumericValue(cString.charAt(i));
    		int fVal = revHexMap.get(hex[i]);
    		int diff = fVal - val;
    		complement.append(diff > 9 ? hexMap.get(diff) : Integer.toString(diff));
    	}
    	String onesComplementStr = complement.reverse().toString();
    	complement.setLength(0);
    	//Two's Complement
    	for (int i = 7; i >= 0; i--) {
    		if (i == 7) {
    			int val = revHexMap.containsKey(onesComplementStr.charAt(i)) ? revHexMap.get(onesComplementStr.charAt(i)) + 1 : Character.getNumericValue(onesComplementStr.charAt(i)) + carry + 1;
    			carry = val / 16;
    			val = val > 15 ? val % 16 : val;
    			complement.append(val > 9 ? hexMap.get(val) : Integer.toString(val));
    		} else {
    			int val = revHexMap.containsKey(onesComplementStr.charAt(i)) ? revHexMap.get(onesComplementStr.charAt(i)) : Character.getNumericValue(onesComplementStr.charAt(i)) + carry;
    			carry = val / 16;
    			complement.append(val > 9 ? hexMap.get(val) : Integer.toString(val));
    		}
    	}
    	return complement.reverse().toString();
    }
    
}