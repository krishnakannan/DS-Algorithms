class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0, y = A[0].length - 1; j < result[0].length && y >= 0; j++, y--) {
                result[i][j] = A[i][y] == 0 ? 1 : 0;
            }
        }
        
        return result;
    }
}