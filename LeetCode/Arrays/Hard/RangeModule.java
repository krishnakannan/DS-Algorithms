import java.util.*;
import java.lang.*;
import java.io.*;

class RangeModule {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		RangeModule rm = new RangeModule();
		int left = in.nextInt();
		int right = in.nextInt();
		int command = in.nextInt();

		while (command > 0 && command < 4) {
			if (command == 1) {
				rm.addRange(left, right);
				rm.print();
			}
			if (command == 2) {
				rm.removeRange(left, right);
				rm.print();
			}
			if (command == 3) {
				System.out.println(rm.queryRange(left, right));
			}
			left = in.nextInt();
			right = in.nextInt();
			command = in.nextInt();
		}
	}

	ArrayList<int[]> rangeList;
	ArrayList<int[]> tempMerged;

    public RangeModule() {
        rangeList = new ArrayList<>();
        tempMerged = new ArrayList<>();
    }
    
    public void addRange(int left, int right) {        
        right -= 1;
        int[] range = new int[]{left, right};
        boolean added = false;
    	if (rangeList.isEmpty() || range[0] <= rangeList.get(0)[0]) {
    		added = true;
    		rangeList.add(0, range);
    	} else {
    		int size = rangeList.size();	    		
            int low = -1;
            int high = rangeList.size() - 1;
            while(low != high - 1) {
                int mid = low + (high - low) / 2;
                if(rangeList.get(mid)[1] > left) 
                    high = mid;
                else 
                    low = mid;
            }
    		for (int i = high; i < size; i++) {
    			if (range[0] < rangeList.get(i)[0]) {
    				added = true;
    				rangeList.add(i, range);
                    break;
    			}
	    	}	    	
    	}
    	if (!added) {
            if (rangeList.get(rangeList.size() - 1)[1] >= range[0] - 1) {
                if (rangeList.get(rangeList.size() - 1)[1] < range[1]) {
                    rangeList.get(rangeList.size() - 1)[1] = range[1];
                }
            } else {
                rangeList.add(range);
            }    		            
    	} else {            
            int l = 0; 
            int r = l + 1;
            tempMerged.clear();
            tempMerged.add(rangeList.get(l));
            //boolean mergeStarted = false;
            int size = rangeList.size();
            while (r < size) {
                if (tempMerged.get(l)[1] >= rangeList.get(r)[0] - 1) {
                    if (tempMerged.get(l)[1] < rangeList.get(r)[1]) {
                        tempMerged.get(l)[1] = rangeList.get(r)[1];    				
                    }
                    r += 1;
                    //mergeStarted = true;
                } else {
                    tempMerged.add(rangeList.get(r));
                    l += 1;
                    r += 1;                    
                }
            }
            rangeList.clear();
            rangeList.addAll(tempMerged);
        }            
    }

    public boolean queryRange(int left, int right) {
        boolean res = binarySearch(0, rangeList.size() - 1, new int[]{left, right - 1});        
        return res;
    }
    
    public void removeRange(int left, int right) {
        
        if (rangeList.size() == 0 || rangeList.get(0)[0] >= right || rangeList.get(rangeList.size() - 1)[1] <= left) {
            return;
        }
        
        right -= 1;
        int[] range = new int[]{left, right};
        
        int low = -1;
        int high = rangeList.size() - 1;
        while(low != high - 1) {
            int mid = low + (high - low) / 2;
            if(rangeList.get(mid)[1] > left) 
                high = mid;
            else 
                low = mid;
        }
        
        
        for (int i = high; i < rangeList.size(); i++) {
    		// System.out.println("RANGE = " + range[0] + "," + range[1] + " LIST " + rangeList.get(i)[0] + "," + rangeList.get(i)[1]);            
    		if (rangeList.get(i)[0] >= range[0] && rangeList.get(i)[1] <= range[1]) {
    			rangeList.remove(i);
                i -= 1;
    		} else if (rangeList.get(i)[0] <= range[0] && rangeList.get(i)[1] >= range[1]) {
    			int temp = rangeList.get(i)[1];
    			rangeList.get(i)[1] = range[0] - 1;
    			rangeList.add(i + 1, new int[]{range[1] + 1, temp});
    		} else {    			
    			if (range[0] >= rangeList.get(i)[0] && range[0] <= rangeList.get(i)[1]) {
    				rangeList.get(i)[1] = range[0] - 1;
    			}                  
                if (range[1] >= rangeList.get(i)[0] && range[1] <= rangeList.get(i)[1]) {    				
    				rangeList.get(i)[0] = range[1] + 1;
    			} 
                if (range[0] < rangeList.get(i)[0] && range[1] < rangeList.get(i)[1]) {                    
                    break;
                }
    		}
    	}
    }

    public boolean binarySearch(int start, int end, int[] sRange) {
    	if (start > end) {
    		return false;
    	}
    	
    	int mid = start + (end - start) / 2;
    	int[] current = rangeList.get(mid);

    	if (start == end) {
    		if (current[0] <= sRange[0] && current[1] >= sRange[1]) {
    			return true;
    		} else {
    			return false;
    		}
    	}    	    	
    	if (current[0] <= sRange[0] && current[1] >= sRange[1]) {
    		return true;
    	} 

    	if (current[1] < sRange[0] && current[1] < sRange[1]) {
    		return binarySearch(mid + 1, end, sRange);
    	} else if (current[0] > sRange[0] && current[0] > sRange[1]) {
    		return binarySearch(start, mid, sRange);
    	} else {
    		return false;
    	}
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */