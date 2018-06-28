class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> rangeList = new ArrayList<>();
        rangeList.add(-25000);
        char[] string = S.toCharArray();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == C) {
                rangeList.add(i);
            }
        }
        int[] result = new int[string.length];
        rangeList.add(25000);
        int left = 0;
        int right = left + 1;
        for (int i = 0; i < string.length; i++) {
            result[i] = min(diff(rangeList.get(left), i), diff(rangeList.get(right), i));
            if (i == rangeList.get(right)) {
                left += 1;
                right = left + 1;
            }
        }
        return result;
    }
    
    public int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }
    
    public int min(int a, int b) {
        return a < b ? a : b;
    }
}