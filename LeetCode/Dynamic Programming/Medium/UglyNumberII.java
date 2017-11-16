class UglyNumberII {

	//https://leetcode.com/problems/ugly-number-ii/description/
	/*
		A Ugly Number is a number which has prime factors which includes only 2,3,5.
		1 is assumed to be ugly
		So obviously numbers 1 to 5 are ugly number.

	*/

	Set<Integer> uglySet;
    public int nthUglyNumber(int n) {
        uglySet = new HashSet<>();
        
        if (n <= 5) {
        	return n;
        }
        
        for (int i = 1; i < 6; i++, n--) {
        	uglySet.add(i);
        }
        int nth = 6;
        int foundVal = 0; 
        while (n > 0) {
        	foundVal = findNextUgly(nth);
        	nth = foundVal + 1;          
        	n--;
        }
        //System.out.println(uglySet);
        return foundVal;
    }

    public int findNextUgly(int startVal) {
    	boolean haveNotFound = true;
    	int num = startVal;
    	while (haveNotFound) {
            num = startVal;
    		if (num % 2 == 0) {
    			num /= 2;
    			if (uglySet.contains(num)) {                    
    				uglySet.add(startVal);
    				haveNotFound = false;
    			} else {
                    startVal++;
                }
    		} else if (num % 3 == 0) {
    			num /= 3;
    			if (uglySet.contains(num)) {
    				uglySet.add(startVal);
    				haveNotFound = false;
    			} else {
                    startVal++;
                }
    		} else if (num % 5 == 0) {
    			num /= 5;
    			if (uglySet.contains(num)) {
    				uglySet.add(startVal);
    				haveNotFound = false;
    			} else {
                    startVal++;
                }
    		} else {
    			startVal++;
    		}
    	}
    	return startVal;
    }
}