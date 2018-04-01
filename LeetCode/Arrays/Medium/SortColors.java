class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < nums.length; i++) {
            red = nums[i] == 0 ? red + 1 : red;
            white = nums[i] == 1 ? white + 1 : white;
            blue = nums[i] == 2 ? blue + 1 : blue;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else {
                if (white > 0) {
                    nums[i] = 1;
                    white--;
                } else if (blue > 0) {
                    nums[i] = 2;
                    blue--;
                }
            }
        }
    }
}