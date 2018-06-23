class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int[] prev = costs[0];
        for (int i = 1; i < costs.length; i++) {
            int min0 = Math.min(prev[1], prev[2]);
            int min1 = Math.min(prev[0], prev[2]);
            int min2 = Math.min(prev[0], prev[1]);
            costs[i][0] += min0;
            costs[i][1] += min1;
            costs[i][2] += min2;
            prev = costs[i];
        }        
        int min = Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
        return min;
    }
    
//     public void print(int[][] c) {
//         for (int i = 0; i < c.length; i++) {
//             for(int j = 0; j < c[0].length; j++) {
//                 System.out.print(c[i][j] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();
//     }
}