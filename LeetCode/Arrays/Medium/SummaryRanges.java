public class Solution {
    public List<String> summaryRanges(int[] nums) {        
        String value = null;
        List<String> list = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {        	
                if (i == 0) {
                    intList.add(nums[i]);
                } else if (nums[i] - nums[i - 1] != 1) {
                	if (intList.size() == 1) {
        				value = Integer.toString(intList.get(0));
        			} else {
        				value = new String(intList.get(0) + "->" + intList.get(intList.size() - 1));                	
        			}            
                	list.add(value);
                	intList.clear();   
                	intList.add(nums[i]);
                } else {
                	intList.add(nums[i]);
                	continue;
                }
        }   
        if (!intList.isEmpty()) {
        	if (intList.size() == 1) {
        		list.add(Integer.toString(intList.get(0)));

        	} else {
        		value = new String(intList.get(0) + "->" + intList.get(intList.size() - 1));                	
        		list.add(value);
        	}
        }
        
        return list;
    }
}