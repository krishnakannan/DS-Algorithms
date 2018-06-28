class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] output = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            output[i] = map.get(A[i]);
        }
        return output;
    }
}