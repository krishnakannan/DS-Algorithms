class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();

        if (x < arr[0]) {
        	int index = 0;
        	while (--k >= 0) {
        		result.add(arr[index]);
        		index++;
        	}
        } else if (x > arr[arr.length - 1]) {
        	int index = (arr.length - 1) - k + 1;
        	while (--k >= 0) {
        		result.add(arr[index]);
        		index++;
        	}
        } else {
        	int index = binarySearch(arr, 0, arr.length - 1, x);        	
            int sIndex = index;
            int eIndex = index;

            while (--k > 0 && sIndex > 0 && eIndex < arr.length - 1) {
                
                if ((x - arr[sIndex - 1]) <= arr[eIndex + 1] - x) {
                    sIndex--;
                } else {
                    eIndex++;
                }             
            }
            if (k > 0) {
                if (eIndex == arr.length - 1) {
                    while (--k >= 0) {
                        sIndex--;
                    }
                } else {
                    while (--k >= 0) {
                        eIndex++;
                    }
                }
            }            
        	for (int i = sIndex; i <= eIndex; i++) {
        		result.add(arr[i]);
        	}
        }

        return result;
    }

    public int binarySearch(int[] arr, int start, int end, int searchVal) {
    	int middle = start + ((end - start) / 2);
        if (end - start == 1) {            
            return (searchVal - arr[start]) < (arr[end] - searchVal) ? start : end;
            
        }
        
        if (start > end) {
            return middle;
        }
    	//End Conditions

    	if (arr[middle] == searchVal) {
    		return middle;
    	}

    	if (start == end) {
    		return middle;
    	}
    	
    	if (arr[middle] > searchVal) {
    		return binarySearch(arr, start, middle, searchVal);
    	} else {
    		return binarySearch(arr, middle, end, searchVal);
    	}
    }
}