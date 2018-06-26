class Solution {
    public boolean judgeCircle(String movesString) {
        int[] point = new int[2];
        char[] moves = movesString.toCharArray();
        for (int i = 0; i < moves.length; i++) {
            if (moves[i] == 'U') {
                point[0] -= 1;
            } else if (moves[i] == 'D') {
                point[0] += 1;
            } else if (moves[i] == 'L') {
                point[1] -= 1;
            } else if (moves[i] == 'R') {
                point[1] += 1;
            }
        }
        
        return point[0] == 0 && point[1] == 0;
    }
}