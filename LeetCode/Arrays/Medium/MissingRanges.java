class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
    	List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                result.add(Integer.toString(lower));
            } else {
                result.add(Integer.toString(lower) + "->" + Integer.toString(upper));
            }
            return result;
        }
        
    	if (nums[0] > lower) {            
            long beginEnd = (long)nums[0] - 1;
            if (lower == beginEnd) {
                result.add(Integer.toString(lower));
            } else {
                result.add(Integer.toString(lower) + "->" + Long.toString(beginEnd));   
            }
			 
		}


    	for (int i = 0; i < nums.length - 1; i++) {    		
            String range = "";            
    		if (nums[i + 1] - nums[i] == 1) {                
    			continue;
    		} else {                                
    			long start = (long)nums[i] + 1;
    			long end = (long)nums[i + 1] - 1;                                
    			if (start == end) {
    				range = Long.toString(start);
    			} else if (start < end) {
    				range = start + "->" + end;
    			}
                if (!range.isEmpty()) {
                    result.add(range);    
                }    			
    		}
    	}

    	long finalStart = (long)nums[nums.length - 1] + 1;                
    	if (upper >= finalStart) {
    		if (finalStart == upper) {
    			result.add(Long.toString(finalStart)); 
    		} else {
    			result.add(Long.toString(finalStart) + "->" + Integer.toString(upper));
    		}
    	}

    	return result;

    }
}