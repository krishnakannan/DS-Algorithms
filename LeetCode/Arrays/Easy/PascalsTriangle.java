public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
	    for (int i = 0; i < numRows; i++) {
	    	List<Integer> tempList = new ArrayList<>();
	    	for (int j = 0; j <= i; j++) {
	    		if (j == 0 || j == i) {
	    			tempList.add(j, 1);
	    		} else {
	    			tempList.add(j, (list.get(i - 1).get(j - 1) + list.get(i-1).get(j)));
	    		}
	    	}
	    	list.add(tempList);
	    }

	    return list;
    }
}