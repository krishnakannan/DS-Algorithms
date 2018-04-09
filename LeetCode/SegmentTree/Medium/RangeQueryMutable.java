class NumArray {

	int[] segTree;
	int[] nums;
	int[] indexMapping;

    public NumArray(int[] nums) {         
        segTree = new int[getSegTreeLength(nums.length)];
        indexMapping = new int[nums.length];
        Arrays.fill(indexMapping, -1);
        this.nums = nums;
        constructSegmentTree(0, nums.length - 1, 0);        
        //print(segTree);
    }
    
    public void update(int i, int val) {
     	updateSegmentTree(i, val);
    }
   	
    public int sumRange(int i, int j) {        
        return query(i, j, 0, nums.length - 1, 0);
    }        

    //Construct Tree

    public void constructSegmentTree(int start, int end, int sIndex) {        
        if (nums.length == 0) {
            return;
        }
    	if (start == end) {
    		segTree[sIndex] = nums[start];
    		indexMapping[start] = sIndex;
    		return;
    	}

    	int mid = (end + start) / 2;
    	constructSegmentTree(start, mid, getLeftChildIndex(sIndex));
    	constructSegmentTree(mid + 1, end, getRightChildIndex(sIndex));

    	segTree[sIndex] = segTree[getLeftChildIndex(sIndex)] + segTree[getRightChildIndex(sIndex)];    	
    }

    //Update Tree

    public void updateSegmentTree(int index, int value) {        
    	int sIndex = indexMapping[index];
        if (sIndex == 0) {
            segTree[sIndex] = value;
            return;
        }
    	int difference = value - segTree[sIndex];
    	segTree[sIndex] = value;
    	sIndex = getParentIndex(sIndex);                
    	while (sIndex >= 0) {
    		segTree[sIndex] += difference;
            if (sIndex == 0) {
                break;
            }
    		sIndex = getParentIndex(sIndex);            
    	}        
    }

    //Query Tree

    public int query(int rStart, int rEnd, int start, int end, int sIndex) {        
        if (sIndex >= segTree.length || start > end) {
            return 0;
        }        
    	//Complete Overlap;
    	if (start >= rStart && end <= rEnd) {            
    		return segTree[sIndex];
    	}
    	//No Overlap
    	if (start > rEnd || end < rStart) {                            
    		return 0;
    	}                
    	//Partial Overlap;        
    	int mid = (end + start) / 2;
    	return query(rStart, rEnd, start, mid, getLeftChildIndex(sIndex)) + query(rStart, rEnd, mid + 1, end, getRightChildIndex(sIndex));

    }


    //Utilities for Readability;

    public int getSegTreeLength(int arrayLength) {
    	int n = 1;    	
    	while (n < arrayLength) {
    		n *= 2;
    	}
        n *= 2;
        n -= 1;
    	return n;
    }

    public int getLeftChildIndex(int parentIndex) {
    	return (parentIndex * 2) + 1;
    }

    public int getRightChildIndex(int parentIndex) {
    	return (parentIndex * 2) + 2;
    }

    public int getParentIndex(int childIndex) {
    	return (childIndex - 1) / 2;
    }

    public void print(int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */