class Solution {

    int[] shuffledArray;
    int[] originalArray;    
    
    public Solution(int[] nums) {
        
        shuffledArray = new int[nums.length];
        shuffledArray = Arrays.copyOf(nums, nums.length);
        originalArray = nums;        
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {        
        shuffledArray = new int[originalArray.length];
        shuffledArray = Arrays.copyOf(originalArray, originalArray.length);
        return shuffledArray;
    }
    
    //Fisher-Yates Implementation
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {        
        int temp = 0;
        for (int i = 0; i < shuffledArray.length; i++) {
            int j = (int)(Math.random() * ((originalArray.length - 1) + 1));                
            temp = shuffledArray[i];
            shuffledArray[i] = shuffledArray[j];
            shuffledArray[j] = temp;
        }
        return shuffledArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */