class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> candyKind = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            candyKind.add(candies[i]);
        }
        return Math.min(candyKind.size(), candies.length / 2);
    }
}