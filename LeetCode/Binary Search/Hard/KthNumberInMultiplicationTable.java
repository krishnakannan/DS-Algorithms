class Solution {
    
    public int getCountOf(int limit, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(limit / i, n);
        }
        return count;
    }
    
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int mid = low + (high - low) / 2;
        while (low < high) {
            mid = low + (high - low) / 2;            
            int count = getCountOf(mid, m, n, k);
            //Reduce the search space
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}