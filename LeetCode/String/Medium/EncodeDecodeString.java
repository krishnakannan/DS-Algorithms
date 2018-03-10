//Let's Assume that the max length of String is 999.

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	StringBuilder sBuilder = new StringBuilder();
        for (String str : strs) {
        	String strLen = getLengthAsString(str);
        	sBuilder.append(strLen);
        	sBuilder.append(str);
        }
        //System.out.println(strs);
        return sBuilder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        // System.out.println();
        // System.out.println(s);
        List<String> sList = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return sList;
        }
           
        int index = 0;
        int sLen = s.length();
        
        while (index < sLen) {
        	String strLen = s.substring(index, index + 3);
        	index += 3;
        	int len = convertToInt(strLen);
        	StringBuilder sBuilder = new StringBuilder();
        	for (int i = 0; i < len; i++, index++) {
        		sBuilder.append(s.charAt(index));
        	}
        	sList.add(sBuilder.toString());
        }
        return sList;
    }

    public String getLengthAsString(String str) {
    	StringBuilder sBuilder = new StringBuilder();
    	int length = str.length();
    	int digits = length == 0 ? 0 : (int) (Math.log10(length) + 1);
    	for (int i = 0; i < 3 - digits; i++) {
    		sBuilder.append("0");
    	}
        if (length != 0) {
            sBuilder.append(length);    
        }    	
    	return sBuilder.toString();
    }

    public int convertToInt(String str) {
    	int val = 0;    	
    	for (int i = 0; i < 3; i++) {
    		val *= 10;
    		val += str.charAt(i) - '0';
    	}
    	return val;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));