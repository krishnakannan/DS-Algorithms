class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        char[] string = S.toCharArray();
        int currentShift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            currentShift += shifts[i];
            currentShift %= 26;
            int curr = (int)string[i] + currentShift;
            curr = curr > 122 ? (curr % 122) + 96 : curr;                    
            string[i] = (char) (curr);
        }
        return new String(string);
    }
}