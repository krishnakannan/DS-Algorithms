class Solution {
    public int maxRotateFunction(int[] A) {
    	int length = A.length;
    	long maxVal = Long.MIN_VALUE;
    	while (--length >= 0) {
    		int val = rotate(A);
    		maxVal = maxVal < val ? val : maxVal;
    	}
    	return (int)maxVal;
    }

    public int rotate(int[] arr) {
    	int lastVal = arr[arr.length - 1];
    	int val = 0;      
        int temp1 = arr[0];
        int temp2;
    	for (int i = 1; i < arr.length; i++) {
    		val += i * arr[i];    		
            temp2 = arr[i];
            arr[i] = temp1;
            temp1 = temp2;            
    	}
    	arr[0] = lastVal;
        //System.out.println(val);
    	return val;
    }
}