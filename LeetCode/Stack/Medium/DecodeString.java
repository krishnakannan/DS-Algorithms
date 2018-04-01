public class Solution {
    public String decodeString(String s) {

		Stack<Character> stack = new Stack<>();
		int length = s.length();
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (stack.empty()) {
				stack.push(s.charAt(i));
				continue;
			}
			StringBuilder sb = new StringBuilder();
			StringBuilder tb = new StringBuilder();
			int times = 1;
			if (s.charAt(i) == ']') {
				
				while (stack.peek() != '[') {
					sb.append(stack.pop());
				}
				stack.pop();
				while (!stack.empty() && (stack.peek() == ']' || (Character.getNumericValue(stack.peek()) < 10 && Character.getNumericValue(stack.peek()) >= 0) ))  {
					tb.append(stack.pop());
				}
				if (tb.length() > 0) {
					times = Integer.parseInt(tb.reverse().toString());	
				}
				// System.out.println("sb "  + sb);
				// System.out.println("tb "  + tb);
				// System.out.println("times "  + tb);
				if (!stack.empty() && stack.peek() != ']') {
					sb = sb.reverse();
					int sbLength = sb.length();
					while (--times >= 0) {
						for (int x = 0; x < sbLength; x++) {
							stack.push(sb.charAt(x));
						}		
					}	
				} else {
					sb = sb.reverse();
					while (--times >= 0) {
						sBuilder.append(sb);
					}	
				}				
			} else {
				// System.out.println("Push" + s.charAt(i));
				stack.push(s.charAt(i));
			}
		}

		StringBuilder fsb = new StringBuilder();				
		while (!stack.empty()) {				
			fsb.append(stack.pop());
		}
		fsb = fsb.reverse();
		sBuilder.append(fsb);
    
        return sBuilder.toString();
    }
}