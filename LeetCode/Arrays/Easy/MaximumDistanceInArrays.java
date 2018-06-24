class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minimumMost = arrays.get(0).get(0);
        int maximumMost = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;
        for (int i = 1; i < arrays.size(); i++) {
            maxDist = Math.max(maxDist, Math.max(Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) -  minimumMost), Math.abs(maximumMost - arrays.get(i).get(0))));
            minimumMost = Math.min(minimumMost, arrays.get(i).get(0));
            maximumMost = Math.max(maximumMost, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return maxDist;
    }
}