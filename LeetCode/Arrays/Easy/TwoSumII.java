public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1;
        int index2;
        int temp;
        int op[] = new int[2];
        for (int i = 0; i < numbers.length; i++) {
        	if (target >= numbers[i]) {
        		index1 = i;
        		temp = target - numbers[i];
        		for (int j = i + 1; j < numbers.length; j++) {        			
        			if (temp == numbers[j]) {
        				index2 = j;
        				op[0] = index1 + 1;
        				op[1] = index2 + 1;
        				return op;
        			}
        		}
        	}
        }
        return op;    
    }
}