class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
 		
    	Stack <Integer> stack = new Stack<>();
        int[] output = new int[n];
        int i = 0;
        int prev = 0;
        for (String log : logs) {
        	String[] lArray = log.split(":");

            if (i == 0) {
                i++;
                stack.push(Integer.parseInt(lArray[0]));
                prev = Integer.parseInt(lArray[2]);
            }
	        
	         
	        
	        if (lArray[1].equals("start")) {
                if (!stack.isEmpty()) {                	
                    output[stack.peek()] += Integer.parseInt(lArray[2]) - prev;
                }
                stack.push(Integer.parseInt(lArray[0]));
                prev = Integer.parseInt(lArray[2]);
            } else {
                output[stack.peek()] += Integer.parseInt(lArray[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(lArray[2]) + 1;
            }

        }

        return output;
    }
}