class Solution {
    
    //Next Permutation Algorithm.
    
    public int nextGreaterElement(int n) {
        if (n < 10) {
            return -1;
        }
        
        char[] number = Integer.toString(n).toCharArray();
        
        int right = number.length - 1;
        int left = right - 1;
        while (left >= 0) {
            if (number[left] < number[right]) {
                break;
            } else {
                left--;
                right--;
            }
        }
        if (left < 0) {
            return -1;
        }
        
        char lVal = number[left];
        
        while (right < number.length && number[right] > lVal) {
            right++;
        }
        right--;
        number[left] = number[right];
        number[right] = lVal;
        left++;
        right = number.length - 1;
        
        while (left < right) {
            char temp = number[left];
            number[left] = number[right];
            number[right] = temp; 
            left++;
            right--;
        }
        return getInt(number);
    }
    
    public int getInt(char[] arr) {
        long val = 0;
        for (int i = 0; i < arr.length; i++) {
            val *= 10;
            val += arr[i] - '0';
            if (val > Integer.MAX_VALUE) {
                return -1;
            }
        }
        return (int)val;
    }
    
    
}