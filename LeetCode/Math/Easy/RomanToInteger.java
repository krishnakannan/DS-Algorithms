public class Solution {
    public int romanToInt(String s) {
        int len = s.length();
		int retValue = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == 'I') {
				if ((i + 1) < len && s.charAt(i + 1) == 'X'){
					retValue += 9;
					i++;
				} else if ((i + 1) < len && s.charAt(i + 1) == 'V'){
					retValue += 4;
					i++;
				} else {
					retValue += 1;
				}
			} else if (s.charAt(i) == 'V') {
				retValue += 5;
			} else if (s.charAt(i) == 'X') {
				if ((i + 1) < len && s.charAt(i + 1) == 'C'){
					retValue += 90;
					i++;
				} else if ((i + 1) < len && s.charAt(i + 1) == 'L'){
					retValue += 40;
					i++;
				} else {
					retValue += 10;
				}
			} else if (s.charAt(i) == 'L') {
				retValue += 50;
			} else if (s.charAt(i) == 'C') {
				if ((i + 1) < len && s.charAt(i + 1) == 'M'){
					retValue += 900;
					i++;
				} else if ((i + 1) < len && s.charAt(i + 1) == 'D'){
					retValue += 400;
					i++;
				} else {
					retValue += 100;
				}
			} else if (s.charAt(i) == 'D') {
				retValue += 500;
			} else if (s.charAt(i) == 'M') {
				retValue += 1000;
			}

		}
		return retValue;    
    }
}