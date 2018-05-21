class Solution {
	
    public int[] smallestRange(List<List<Integer>> nums) {
    	int[] finalRange = new int[2];
    	int minRange = Integer.MAX_VALUE;
    	int[] indexArray = new int[nums.size()];
        /*
            SortedList has int array of size 2.
            first index will be the actual number
            second index will be the nth list in list of list in which the actual number is.
        */
        ArrayList<int[]> sortedList = new ArrayList<>();    	
    	int index = 0;        
    	for (List<Integer> numsList : nums) {    	            
    		sortedList.add(new int[]{numsList.get(0), index});
            index += 1;
    	}
        Collections.sort(sortedList, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            } 
        });
        //printSet(sortedList);

    	while (sortedList.size() == nums.size()) {
    		int[] first = sortedList.get(0);
    		int[] last = sortedList.get(sortedList.size() - 1);            
    		int range = last[0] - first[0];
             //printSet(sortedList);
            // System.out.println("First " + first.num + " Last " + last.num + " Range " + range);
    		if (range < minRange) {
    			minRange = range;
    			finalRange[0] = first[0];
    			finalRange[1] = last[0];
    		}
    		int removeIndex = first[1];
    		indexArray[removeIndex] += 1;
            sortedList.remove(0);
    		if (indexArray[removeIndex] < nums.get(removeIndex).size()) {                     
    			int numberAtTop = nums.get(removeIndex).get(indexArray[removeIndex]);
                int insertIndex = sortedList.isEmpty() ? 0 : binarySearch(sortedList, 0, sortedList.size() - 1, numberAtTop);
    			sortedList.add(insertIndex, new int[]{numberAtTop, removeIndex});
    		}
            //System.out.println("Set " + set.size() + " Orig " + nums.size());
    	}

    	return finalRange;
    }
    
    public void printSet(ArrayList<int[]> list) {
        for (int[] element : list) {
            System.out.print(element[0] + ", ");
        }
        System.out.println();
    }
    
    public int binarySearch(ArrayList<int[]> list, int start, int end, int searchKey) {
        
        if (start == end) {
            if (list.get(start)[0] > searchKey) {
                return start;
            } else {
                return end + 1;    
            }
            
        }
        
        int middle = start + (end - start) / 2;
        
        if (list.get(middle)[0] == searchKey) {
            return middle;
        }
        
        if (list.get(middle)[0] > searchKey) {
            return binarySearch(list, start, middle, searchKey);
        } else {
            return binarySearch(list, middle + 1, end, searchKey);
        }
    }
}