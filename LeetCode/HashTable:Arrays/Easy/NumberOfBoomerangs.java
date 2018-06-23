class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int boomerangs = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) { 
                    continue;
                } 
                int dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);                
            }
            
            for (Integer value : map.values()) {
                boomerangs += value * (value - 1);
            }
            map.clear();
        }
        return boomerangs;
    }
    
    public int getDist(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return (x * x) + (y * y);
    }
}