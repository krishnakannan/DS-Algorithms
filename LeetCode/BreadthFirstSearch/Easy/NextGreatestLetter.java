class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length;
        
        while (start < end) {
            int mid = start + ((end - start) / 2);
            //System.out.println("Start " + start + " End " + end + " Mid " + mid);
            if (letters[mid] <= target) {
                start = mid + 1;                
            } else {
                end = mid;
            }
        }
        return letters[start % letters.length];
    }
}