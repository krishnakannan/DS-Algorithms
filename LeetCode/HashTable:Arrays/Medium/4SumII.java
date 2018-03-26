class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> cdSumMap = new HashMap<>();
        
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                cdSumMap.put(sum, cdSumMap.containsKey(sum) ? cdSumMap.get(sum) + 1 : 1);
            }
        }
        
        int fourSum = 0;
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int num = A[i] + B[j];
                if (cdSumMap.containsKey(-num)) {
                    fourSum += cdSumMap.get(-num);
                }
            }
        }
        
        return fourSum;
        
    }
}