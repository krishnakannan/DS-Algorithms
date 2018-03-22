class Solution {

	Stack<Integer> stack = new Stack<>();

    public int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        int index = 1;
        result[0] = 1;
        int currentNum = 1;
        char[] secret = s.toCharArray();
        int sIndex = 0;
        
        while (sIndex < secret.length) {        	
        	if (secret[sIndex] == 'D') {
        		stack.push(result[index - 1]);
                result[index - 1] = 0;
        		index--;
        		while (sIndex < secret.length && secret[sIndex] == 'D') {
                    currentNum++;
        			stack.push(currentNum);        			
        			sIndex++;
        		}
        	} else {
        		while (!stack.empty()) {
        			result[index++] = stack.pop();
        		}

        		while (sIndex < secret.length && secret[sIndex] == 'I') {
                    currentNum++;
        			result[index++] = currentNum;        			
        			sIndex++;
        		}
        	}
        }
        
        while (!stack.empty()) {
            result[index++] = stack.pop();
        }
        
        return result;
    }
}