class Solution {
    //Referred
    public int bestRotation(int[] A) {
        int[] intervals = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int lBad = (i - A[i] + 1 + A.length) % A.length;
            int rBad = (i + 1) % A.length;
            intervals[lBad] -= 1;
            intervals[rBad] += 1;
            if (lBad > rBad) {
                intervals[0] -= 1;
            }
        }
        
        int leastInterval = Integer.MIN_VALUE;
        int currentOverlap = 0;
        int kthRotation = -1;
        
        for (int i = 0; i < A.length; i++) {
            currentOverlap += intervals[i];
            if (currentOverlap > leastInterval) {
                leastInterval = currentOverlap;
                kthRotation = i;
            }
        }
        return kthRotation;
    }
}