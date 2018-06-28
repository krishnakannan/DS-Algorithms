class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int currentLineLength = 0;
        int totalLines = 0;
        for (int i = 0; i < S.length(); i++) {
            if (currentLineLength + widths[S.charAt(i) - 'a'] <= 100) {
                currentLineLength += widths[S.charAt(i) - 'a'];
            } else {
                totalLines += 1;
                currentLineLength = widths[S.charAt(i) - 'a'];
            }
        }
        return new int[]{totalLines + 1 , currentLineLength};
    }
}