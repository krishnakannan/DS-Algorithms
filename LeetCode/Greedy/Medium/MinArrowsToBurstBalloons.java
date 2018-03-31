class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });       
        int[] existingRange = new int[2];
        existingRange[0] = points[0][0];
        existingRange[1] = points[0][1];
        
        int arrows = 1;
        
        for (int i = 1; i < points.length; i++) {         
            if (existingRange[1] >= points[i][0]) {
                existingRange[0] = existingRange[0] < points[i][0] ? points[i][0] : existingRange[0];
                existingRange[1] = existingRange[1] > points[i][1] ? points[i][1] : existingRange[1];
            } else {
                arrows++;
                existingRange[0] = points[i][0];
                existingRange[1] = points[i][1];
            }
        }    
        return arrows;
    }
    
}