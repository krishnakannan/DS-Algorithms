public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
        	for (int j = 0; j < 60; j++) {
        		if ((Integer.bitCount(i) + Integer.bitCount(j)) == num) {
        			ret.add(String.format("%d:%02d", i, j));	
        		}
        	}
        }
        return ret;
    }
}