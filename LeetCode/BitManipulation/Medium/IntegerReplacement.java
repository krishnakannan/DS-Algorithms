class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        if (n == Integer.MAX_VALUE) {
            n--;
        }
        while (n > 0) {
            //System.out.println(n);
            if (n % 2 == 0) {
                n /= 2;
            } else {
                if (goUp(n)) {
                    n += 1;
                } else {
                    n -=1;
                }
            }
            count++;
        }
        return --count;
    }
    
    public boolean goUp(int n) {
        if (n == 1 || n == 3) {
            return false;
        }
     
        int plus1 = 0;
        int minus1 = 0;
        
        int temp = n + 1;
        
        while (temp > 0) {
            plus1 = (temp & 1) == 0 ? plus1 : plus1 + 1;
            temp = temp >>> 1;
        }
         
        temp = n - 1;
        
        while (temp > 0) {
            minus1 = (temp & 1) == 0 ? minus1 : minus1 + 1;
            temp = temp >>> 1;
        }
        
        return plus1 <= minus1;
    }
}