class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> nums = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (validate(i)) {
                nums.add(i);
            }
        }
        return nums;
    }
    
    public boolean validate(int num) {
        int dVal = num;
        
        while (dVal > 0) {
            int d = dVal % 10;
            if (d == 0) {
                return false;
            }
            if (num % d != 0) {
                return false;
            }
            dVal /= 10;
        }
        return true;
    }
}