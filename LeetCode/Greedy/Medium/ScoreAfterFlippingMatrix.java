class Solution {
    public int matrixScore(int[][] A) { 
        maximize(A);
        int total = 0;
        for (int[] row : A) {
            total += getNum(row);
        }
        return total;
    }
    
    // Matrix row starting with 1 if we flip it will change the first to 0 ie the MSB to 0 which definitely will result in lesser number. Conversely change that starts with 0. 
    // Once after doing that change the cols that have more 0s than 1. Which means the bit has same weightage and number of 2s matter more here.
    
    public int getNum(int[] num) {
        int val = 0;
        for (int i = 0; i < num.length; i++) {
            val *= 2;
            val += num[i];
        }
        return val;
    }
    
    public void maximize(int[][] mat) {
        boolean flip = false;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] == 0) {
                flip = true;
            }
            for (int j = 0; j < mat[0].length && flip; j++) {
                mat[i][j] = mat[i][j] == 0 ? 1 : 0;
            }
            flip = false;
        }
        
        for (int j = 0; j < mat[0].length; j++) {
            int oneCount = 0;
            int zeroCount = 0;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == 0) {
                    zeroCount += 1;
                } else {
                    oneCount += 1;
                }
            }
            
            if (zeroCount > oneCount) {
                flip = true;
            }
            
            for (int i = 0; i < mat.length && flip; i++) {
                mat[i][j] = mat[i][j] == 0 ? 1 : 0;
            }
            flip = false;
        }
    }
}