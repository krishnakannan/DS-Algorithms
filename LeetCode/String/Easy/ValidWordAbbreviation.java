class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
		StringBuilder builder = new StringBuilder();
		char[] abbrArray = abbr.toCharArray();

		for (int i = 0; i < abbrArray.length; i++) {
			if (abbrArray[i] < '0' || abbrArray[i] > '9') {
    			builder.append(abbrArray[i]);
    		} else {
    			int num = getNum(abbrArray, i);
    			if (num == 0 || abbrArray[i] == '0') {
    				return false;
    			}
                if (num > word.length()) {
                    return false;
                }
    			while (--num >= 0) {
    				builder.append("$");
    			}
    			while (i < abbrArray.length && abbrArray[i] >= '0' && abbrArray[i] <= '9') {
    				i += 1;
    			}
                i -= 1;
    		}
		}
		String expanded = builder.toString();        
        if (expanded.length() != word.length()) {
            return false;
        }
		for (int i = 0; i < word.length(); i++) {
			if (expanded.charAt(i) == '$') {
				continue;
			} else if (expanded.charAt(i) != word.charAt(i)) {
				return false;
			}
		}

		return true;

    }

    public int getNum(char[] word, int index) {
    	int val = 0;
    	while (index < word.length) {
    		if (word[index] < '0' || word[index] > '9') {
    			break;
    		}
    		val *= 10;
    		val += word[index] - '0';
            index += 1;
    	}
    	return val;
    }
}