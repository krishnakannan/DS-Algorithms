class Solution {
    public int minSwap(int[] A, int[] B) {
        int o1 = 0;
        int s1 = 1;
        for (int i = 1; i < A.length; i++) {
            int o2 = Integer.MAX_VALUE;
            int s2 = Integer.MAX_VALUE;
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                o2 = Math.min(o2, o1);
                s2 = Math.min(s2, s1 + 1);
            }
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                o2 = Math.min(o2, s1);
                s2 = Math.min(s2, o1 + 1);
            }
            o1 = o2;
            s1 = s2;
        }
        return Math.min(o1, s1);
    }
}