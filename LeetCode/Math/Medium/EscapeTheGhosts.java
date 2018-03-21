class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
    	int minGhostDistanceToTarget = Integer.MAX_VALUE;
        int distanceToTarget = getDistance(new int[]{0,0}, target);

        for (int[] ghost : ghosts) {
        	int ghostDistanceToTarget = getDistance(ghost, target);
        	minGhostDistanceToTarget = minGhostDistanceToTarget > ghostDistanceToTarget ? ghostDistanceToTarget : minGhostDistanceToTarget;
        }
        
        //System.out.println("Distance to Target " + distanceToTarget + " Ghost Distance to target " + minGhostDistanceToTarget);

        return distanceToTarget < minGhostDistanceToTarget;

    }

    public int getDistance(int[] source, int[] destination) {
    	int verticalDistance = diff(source[0], destination[0]);
    	int horizontalDistance = diff(source[1], destination[1]);
    	return verticalDistance + horizontalDistance;
    }

    public int diff(int a, int b) {
    	return a > b ? (a - b) : (b - a);
    }
}