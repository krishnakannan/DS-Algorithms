class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> largeGroup = new ArrayList<>();
        char[] string = S.toCharArray();
        int left = 0;
        int right = left + 1;        
        while (right < string.length) {
            if (string[right] == string[right - 1]) {
                right += 1;
            } else {
                if (right - left >= 3) {
                    List<Integer> group = new ArrayList<>();
                    group.add(left);
                    group.add(right - 1);
                    largeGroup.add(group);
                }
                left = right;
                right = left + 1;
            }
        }
        if (right - left >= 3) {
            List<Integer> group = new ArrayList<>();
            group.add(left);
            group.add(right - 1);
            largeGroup.add(group);
        }
        return largeGroup;
    }
}