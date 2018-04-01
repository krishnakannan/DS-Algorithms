public class Solution {
    public String reverseStr(String s, int k) {
		int l = 0;
		int length = s.length();
		int x = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		if (k > length) {
			return reverse(s);
		}
			for (int i = 0; i < length; i++, l = i) {
				temp.append(s.charAt(i));
				if ((i + 1) % k == 0) {
					x++;
					if (x % 2 == 0) {
						sb.append(temp.toString());
					} else {
						sb.append(reverse(temp.toString()));
					}
					temp.setLength(0);
				}
			}
			for (int i = l; i < length; i++) {
				temp.append(s.charAt(i));
			}
			x++;
			if (x % 2 == 0) {
				sb.append(temp.toString());
			} else {
				sb.append(reverse(temp.toString()));
			}

		return sb.toString();
    }

    private String reverse(String s) {
    	StringBuilder sBuidler = new StringBuilder();
    	for (int i = s.length() - 1; i >= 0; i--) {
    		sBuidler.append(s.charAt(i));
    	}
    	return sBuidler.toString();
    }
}