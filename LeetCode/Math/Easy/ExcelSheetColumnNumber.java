class Solution {
    public int titleToNumber(String s) {
        int total = 0;
        int exp = 0;
        char[] sArr = s.toCharArray();
        for (int i = sArr.length - 1; i >= 0; i--) {
            int alpha = sArr[i] - 64;
            if (exp > 0) {
                alpha *= Math.pow(26, exp);    
            }            
            //System.out.println(alpha);
            exp++;
            total += alpha;            
        }
        return total;
    }
}