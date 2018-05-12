class Solution {
    public int newInteger(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 9) {
            return n;
        }
        //Converting the number to base 9;
        String number = new String();
        while (n > 0) {
            int temp = n % 9;
            number = temp + number;                       
            n /= 9;
        }
        long val = getNum(number);
        
        return val > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)val;
    }
    
    public long getNum(String num) {        
        long val = 0;
        for (int i = 0; i < num.length(); i++) {
            val *= 10;
            val += num.charAt(i) - '0';
        }
        return val;
    }
}