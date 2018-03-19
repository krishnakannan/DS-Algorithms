class Solution {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];        
        

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], 1);
            Arrays.fill(dp[i], Integer.MAX_VALUE);            
        }

        for (int[] coords : mines) {
            arr[coords[0]][coords[1]] = 0;
            dp[coords[0]][coords[1]] = 0;
        }

        int largestPlus = mines.length == (N * N) ? 0 : 1;

        fillBorder(dp, arr);


        for (int i = 1; i < arr.length - 1; i++) {

            int plusLength = arr[i][0];

            //Left to Right
            for (int j = 1; j < arr[0].length - 1; j++) {
                plusLength = dp[i][j] == 0 ? 0 : plusLength + 1;
                dp[i][j] = plusLength;
            }
            
            plusLength = arr[i][arr.length - 1];;

            //Right to Left
            for (int j = arr[0].length - 2; j > 0; j--) {
                plusLength = dp[i][j] == 0 ? 0 : plusLength + 1;
                dp[i][j] = min(dp[i][j], plusLength);
            }
                        
        }


        for (int j = 1; j < arr[0].length - 1; j++) {

            int plusLength = arr[0][j];

            // Top to Bottom
            for (int i = 1; i < arr.length - 1; i++) {
                plusLength = dp[i][j] == 0 ? 0 : plusLength + 1;
                dp[i][j] = min(dp[i][j], plusLength);
            }
            
            plusLength = arr[arr[0].length - 1][j];

            //Bottom to Top
            for (int i = arr.length - 2; i > 0; i--) {
                plusLength = dp[i][j] == 0 ? 0 : plusLength + 1;
                dp[i][j] = min(dp[i][j], plusLength);
                largestPlus = largestPlus < dp[i][j] ? dp[i][j] : largestPlus;
            }
                        
        }

        //printMatrix(dp);


        return largestPlus;
    }


    public int min(int a, int b) {
        return a > b ? b : a;
    }

    public int max(int a, int b) {
        return a < b ? b : a;
    }

    public void fillBorder(int[][] dp, int[][] arr) {

        //Fill First and Last Row
        for (int i = 0; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i];
            dp[arr.length - 1][i] = arr[arr.length - 1][i];
        }

        //Fill First and Last Cols
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = arr[i][0];
            dp[i][arr[0].length - 1] = arr[i][arr[0].length - 1];
        }
    }

    public void printMatrix(int[][] mat) {
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }       
        System.out.println();
    }
}