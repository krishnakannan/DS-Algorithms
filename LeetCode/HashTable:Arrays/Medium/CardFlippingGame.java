class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> cantFlip = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                cantFlip.add(fronts[i]);
            }
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!cantFlip.contains(fronts[i])) {
                smallest = fronts[i] < smallest ? fronts[i] : smallest;
            }
            if (!cantFlip.contains(backs[i])) {
                smallest = backs[i] < smallest ? backs[i] : smallest;
            }
        }
        
        return smallest == Integer.MAX_VALUE ? 0 : smallest;
    }
}