class Solution {
    public int maxArea(int[] height) {
        int lptr = 0;
        int rptr = height.length - 1;
        int maxVal = 0;
        int val = 0;
        while (lptr < rptr) {
            val = 0;
            if (height[lptr] < height[rptr]) {
                val = height[lptr] * (rptr - lptr);
                maxVal = maxVal < val ? val : maxVal;
                lptr++;
            } else {
                val = height[rptr] * (rptr - lptr);
                maxVal = maxVal < val ? val : maxVal;
                rptr--;
            }
        }
        return maxVal;
            
    }
}