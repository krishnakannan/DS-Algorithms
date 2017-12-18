class Solution {

	public boolean isOneEditDistance(String s, String t) {

		if (s.isEmpty() && t.isEmpty()) {
			return false;
		} else if (s.isEmpty()) {
			return t.length() == 1;
		} else if (t.isEmpty()) {
			return s.length() == 1;
		}

		if (diff(s.length(), t.length()) > 1) {
			return false;
		}

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		
		int maxLen = sArr.length > tArr.length ? sArr.length : tArr.length;
		int distance = 0;
		int i = 0;
		int j = 0;

		while (i < sArr.length && j < tArr.length) {
			if (sArr[i] == tArr[j]) {
				i++;
				j++;
				continue;
			} else {
				distance++;
				if (sArr.length > tArr.length) {
					i++;
				} else if (tArr.length > sArr.length) {
					j++;
				} else {
					i++;
					j++;
				}
			}
			if (distance > 1) {
				return false;
			}
		}
		if (i != sArr.length) {
			distance += sArr.length - i;
		}
		if (j != tArr.length) {
			distance += tArr.length - j;
		}        
		return distance == 1;
		
	}

	public int diff(int a, int b) {
		return a > b ? a - b : b - a;
	}
}