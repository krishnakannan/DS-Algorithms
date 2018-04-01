class Solution {
    public int countSubstrings(String s) {
        char[] rows = s.toCharArray();
        char[] cols = s.toCharArray();
        int length = cols.length;
        int[][] arr = new int[length][length];
        int count = length;
        for (int i = 0; i < length; i++) {
        	for (int j = 0; j < length; j++) {
        		if (rows[i] == cols[j]) {
        			arr[i][j] = 1;
        		}
        	}
        }

        for (int x = 0, y = 0; x < length && y < length; x++, y++) {
        	int i = x;
        	int j = y;
        	int k = y;
        	
        	while (i >= 0 && j >= 0 && k < length) {
        		if (i > 0 && k + 1 < length &&  arr[i - 1][j - 1] == 1 && arr[i - 1][k + 1] == 1) {
        			count++;
        			i--;
        			j--;
        			k++;
	        	} else {
	        		break;
	        	}	        	
        	}
        	i = x;
        	j = y;
        	k = y;
        	if (j + 1 < length && arr[i][j] == 1 && arr[i][j + 1] == 1) {
				count++;
				k++;
        		while (i >= 0 && j >= 0 && k < length) {
	        		if (i > 0 && k + 1 < length && arr[i - 1][j - 1] == 1 && arr[i - 1][k + 1] == 1) {
        				count++;
        				i--;
        				j--;
        				k++;
        			} else {
		        		break;
		        	}	        	
	        	}
	        }
        }
        return count;
    }
}