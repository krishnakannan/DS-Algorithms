class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < A.length || left < A.length) {
            int tempCount = 0;
            while (right < A.length && A[right] <= R) {
                right++;
            }            
            tempCount = ((right - left) * (right - left + 1)) / 2;
            int minusCount = 0;
            int cMinusCount = 0;            
            while (left <= right && left < A.length) {                
                if (A[left] < L) {
                    cMinusCount++;
                } else {
                    minusCount += ((cMinusCount * (cMinusCount + 1)) / 2);
                    cMinusCount = 0;
                }    
                left++;
            }
            minusCount += ((cMinusCount * (cMinusCount + 1)) / 2);
            left--;
            //System.out.println("Left = " + left + " Right = " + right + " Count " + count + " tempCount " + tempCount + " minusCount " + minusCount);
            count += tempCount - minusCount;
            right++;
            left++;
            
        }        
        return count;
    }
}