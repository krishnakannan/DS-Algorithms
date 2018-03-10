//N log N Soln

class Solution {
    public int findMinDifference(List<String> timePoints) {
    	Collections.sort(timePoints);

    	int length = timePoints.size();
    	int minimumDifference = Integer.MAX_VALUE;

    	for (int i = 0; i < length - 1; i++) {
    		int diff = getDifference(timePoints.get(i), timePoints.get(i + 1));
    		minimumDifference = diff < minimumDifference ? diff : minimumDifference;
    	}

    	int finalDiff = getDifference(timePoints.get(timePoints.size() - 1), "24:00") 
    			+ getDifference("00:00", timePoints.get(0));

    	minimumDifference = finalDiff < minimumDifference ? finalDiff : minimumDifference;

    	return minimumDifference;
    }

    public int getDifference(String one, String two) {
    	int minDifference = 0;
    	int hrDifference = 0;

    	String[] t1 = one.split(":");
    	String[] t2 = two.split(":");

    	minDifference = getInteger(t2[1]) - getInteger(t1[1]);
    	hrDifference = 60 * (getInteger(t2[0]) - getInteger(t1[0]));

    	return minDifference + hrDifference;
    }

    public int getInteger(String s) {
    	int val = 0;
    	int sLen = s.length();
    	for (int i = 0; i < sLen; i++) {
    		val *= 10;
    		val += s.charAt(i) - '0';
    	}
    	return val;
    }
}