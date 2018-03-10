class Solution {
    public String validIPAddress(String IP) {
    	String validationResult = "Neither";

    	if (IP.contains(".")) {
    		validationResult = validateIPv4(IP);
    	} else if (IP.contains(":")) {
    		validationResult = validateIPv6(IP);
    	}

    	return validationResult;
    }

    public String validateIPv4(String ip) {
    	String[] ipArray = ip.split("\\.");        
    	if (ip.charAt(ip.length() - 1) != '.' && validateIPv4(ipArray)) {
    		return "IPv4";
    	}    	
    	return "Neither";
    }

    public boolean validateIPv4(String[] nums) {
    	if (nums.length != 4) {
    		return false;
    	}
        
        
    	for (String num : nums) {
    		int nLength = num.length();
    		int nInt = getInteger(num);
    		int nIntLength = nInt == 0 ? 1 : (int) (Math.log10(nInt) + 1);            
            //System.out.println("Num " + num + " nLength " + nLength + " nInt " + nInt + " nIntLength " + nIntLength);            
    		if (nInt < 0 || nInt >= 256 || nLength != nIntLength) {
    			return false;
    		}
    	}
    	return true;
    }

    public int getInteger(String numString) {
    	int value = 0;
    	int sLen = numString.length();
    	for (int i = 0; i < sLen; i++) {
    		value *= 10;
    		value += numString.charAt(i) - '0';
    	}
    	return value;
    }


    public String validateIPv6(String ip) {
    	String[] ipArray = ip.split(":");
    	if (ip.charAt(ip.length() - 1) != ':' && validateIPv6(ipArray)) {
    		return "IPv6";
    	}
    	return "Neither";
    }

    public boolean validateIPv6(String[] hexArray) {
    	if (hexArray.length != 8) {
    		return false;
    	}                
        
    	for (String hex : hexArray) {
            int length = hex.length();
    		if (length <= 0 || length > 4) {
    			return false;
    		}
            
    		for (int i = 0; i < length; i++) {
    			if (!validateHex(hex.charAt(i))) {
    				return false;
    			}
    		}
    	}

    	return true;
    }

    public boolean validateHex(char hexChar) {
    	if (hexChar >= '0' && hexChar <= '9') {
    		return true;
    	} else if ((hexChar >= 'a' && hexChar <= 'f') ||(hexChar >= 'A' && hexChar <= 'F')) {
    		return true;
    	} else {
    		return false;
    	}
    }
}