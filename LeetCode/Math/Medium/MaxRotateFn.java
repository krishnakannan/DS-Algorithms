class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0){
            return 0;
        }

        int sum = 0;
        int value = 0;
        int len = A.length;
        
        for (int i = 0; i < len; i++) {
            sum += A[i];
            value += (A[i] * i);
        }
        
        int max = value;
        
        for(int i = 1; i < len; i++){            
            value = value - sum + A[i - 1] * len;
            max = Math.max(max, value);
        }
        
        return max;
    }
}