class Solution {
    public int pathSum(int[] nums) {
        int depth = getMaxDepth(nums);
        int actualSize = (int)Math.pow(2, depth) - 1;
        int[] fbTree = new int[actualSize];
        int pathSum = 0;
        Arrays.fill(fbTree, -1);
        populateTree(nums, fbTree);

        int i = 0; 
        for (; ((2 * i) + 2) < fbTree.length; i++) {                        
        	int lcIndex = i * 2 + 1;
        	int rcIndex = i * 2 + 2;  
            if (fbTree[i] == -1) {
                continue;
            }            
            
        	if (fbTree[lcIndex] == -1 && fbTree[rcIndex] == -1) {
        		//Its a leaf                
        		pathSum += fbTree[i];
        	} else {
        		if (fbTree[lcIndex] != -1) {
        			fbTree[lcIndex] += fbTree[i];
        		}

        		if (fbTree[rcIndex] != -1) {
        			fbTree[rcIndex] += fbTree[i];
        		}
        	}
        }

        for (; i < fbTree.length; i++) {            
            if (fbTree[i] >= 0) {                
                pathSum += fbTree[i];    
            }           
        }
        return pathSum;
    }


    public void populateTree(int[] nums, int[] fbTree) {
    	for (int i = 0; i < nums.length; i++) {
    		int index = getIndex(nums[i]);
    		int val = getVal(nums[i]);
    		fbTree[index] = val;
    	}
    }

    public int getMaxDepth(int nums[]) {
    	int val = nums[nums.length - 1];
    	val = val / 100;
    	return val;
    }

    public int getVal(int num) {    	    	
    	return num % 10;
    }


    /*
		In order to get the index of the number in a Full Binary Tree we perform the following

		index = (2 ^ (depth - 1)) + position - 2;

		Here we subtract 2 because it is zero indexed;

    */
    public int getIndex(int num) {
    	int depth = num / 100;
    	num = num / 10;
    	int position = num % 10;
    	int index = (int)Math.pow(2, (depth - 1)) + (position - 2);
    	return index;
    }
}