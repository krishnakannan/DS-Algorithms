class Solution {
    Map<Character, Character> strobogrammaticPairs;
    public boolean isStrobogrammatic(String num) {
        initMap();
        char[] number = num.toCharArray();
        int left = 0;
        int right = number.length - 1;
        while (left <= right) {
            
            if (!strobogrammaticPairs.containsKey(number[left]) || strobogrammaticPairs.get(number[left]) != number[right]) {
                return false;                
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
    
    public void initMap() {
        strobogrammaticPairs = new HashMap<>();
        strobogrammaticPairs.put('0', '0');
        strobogrammaticPairs.put('1', '1');
        strobogrammaticPairs.put('6', '9');
        strobogrammaticPairs.put('9', '6');
        strobogrammaticPairs.put('8', '8');
    }
}