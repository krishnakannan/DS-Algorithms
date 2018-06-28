class Solution {
    public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> seated = new TreeSet<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                seated.add(i);
            }
        }
        int maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                Integer left = seated.lower(i);
                Integer right = seated.higher(i);                
                int dist = Integer.MAX_VALUE;
                if (left != null) {
                    dist = i - left;
                } 
                if (right != null) {
                    dist = dist > (right - i) ? (right - i) : dist;
                }
                if (dist != Integer.MAX_VALUE && maxDistance < dist) {
                    maxDistance = dist;
                }
            }
        }
        return maxDistance;
    }
}