class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
 		int[] arr = new int[length];
        
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            arr[update[0]] += update[2];
            if (update[1] + 1 < length) {
                arr[update[1] + 1] -= update[2];
            }
        }
                
        for (int x = 1; x < arr.length; x++) {
            arr[x] += arr[x - 1];
        }
        
        return arr;
    }
}