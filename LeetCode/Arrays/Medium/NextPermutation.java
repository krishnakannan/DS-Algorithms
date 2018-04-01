class Solution {
    public void nextPermutation(int[] nums) {
        //Find the Subset
        List<Integer> nSubset = new ArrayList<>();
        List<Integer> nPermute = new ArrayList<>();
        int subsetCount = 0;
        Integer firstElement = -1;
        Integer lastElement = -1;
        Integer newVal = Integer.MAX_VALUE;
        int max = -1;
        int count = 0;
        //nSubset.add(nums[nums.length - 1]);
        
        int lastIndex = -1;
        for (int i = nums.length - 1; i >=0; i--) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                nSubset.add(nums[i]);
            } else {
                nSubset.add(nums[i]);
                lastIndex = i - 1;
                break;
            }
        }
        if (lastIndex >= 0) {
            nSubset.add(nums[lastIndex]);
        }
        subsetCount = nSubset.size();
        firstElement = nSubset.get(subsetCount - 1);        
        lastElement = nSubset.get(0);
        for (int i = 0; i < subsetCount; i++) {
        	if (max < nSubset.get(i)) {
        		max = nSubset.get(i);
        	}
        }
        //System.out.println("First Element = "+ firstElement + " max = " + max + " nSubset = " + nSubset);
        if (firstElement == max && nSubset.size() == nums.length) {
        	Collections.sort(nSubset);
        	nPermute.addAll(nSubset);
        } else if (lastElement == max && nums[nums.length - 2] != nums[nums.length - 1]) {
        	int temp = nums[nums.length - 2];
        	nums[nums.length - 2] = nums[nums.length - 1];
        	nums[nums.length - 1] = temp;
        	return;
        } else {
        	for (int i = subsetCount - 2; i >= 0; i--) {
        		int temp = nSubset.get(i);        		
	        	if (temp > firstElement && temp < newVal) {
	        		newVal = temp;
	        	}
	        }
	        nPermute.add(newVal);	        
        	nSubset.remove(newVal);
        	Collections.sort(nSubset);
        	nPermute.addAll(nSubset);
//        	System.out.println(nPermute);
        }        
        
        for (int i = nums.length - subsetCount; i < nums.length; i++, count++) {
        	// System.out.println("i = " + i + " nums[i] " + nums[i]);
        	nums[i] = nPermute.get(count);	
        }

        // for (int i = 0; i < nums.length; i++) {
        // 	System.out.print(nums[i]);
        // }
        // System.out.println();
    }
}