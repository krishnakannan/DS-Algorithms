import java.util.*;
import java.lang.*;
import java.io.*;

class LongestAbsoluteFilePath {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		LongestAbsoluteFilePath la = new LongestAbsoluteFilePath();
		System.out.println(la.lengthLongestPath(input));
	}

	int index = 0;

    public int lengthLongestPath(String inputString) {
        Stack<String> stack = new Stack<>();
        char[] input = inputString.toCharArray();
        int pathLength = 0;        
        index = 0;
        int currentLevel = 0;
        int nextLevel = 0;
        String word = "";
        while (index < input.length) {
			if (input[index] == '\n') { 
				currentLevel = stack.size() - 1;
				nextLevel = getLevel(input);				
			} else {
				word = getWord(input);
				if (nextLevel <= currentLevel) {
                    int length = getPathLength(stack);
                    pathLength = pathLength < length ? length : pathLength;
					while (!stack.empty() && stack.size() > nextLevel) {						
						stack.pop();
					}	
				}                 
				stack.push(word);
                
				// System.out.println("Current level " + currentLevel + " nextLevel " + nextLevel + " FormedStr " + word);
				// printStack(stack);        		
			}
						
        }

        int length = getPathLength(stack);
        pathLength = pathLength < length ? length : pathLength;
        
        return pathLength;
    }

    public int getLevel(char[] input) {
    	int level = 0;
        index += 1;
 		while (input[index] == '\t') {
 			level++;
 			index++;
 		}
 		return level;
    }

    public String getWord(char[] input) {
    	StringBuilder builder = new StringBuilder();
    	while (index < input.length && input[index] != '\n') {
    		builder.append(input[index]);
    		index++;
    	}
    	return builder.toString();
    }
    
    public int getPathLength(Stack<String> stack) {
        int length = 0;
        if (!stack.empty() && stack.peek().contains(".")) {
            for (String path : stack) {
                length += path.length();
            }
            length += stack.size() - 1;
        }
        return length;
    }

    public void printStack(Stack<String> stack) {
    	System.out.println(Arrays.toString(stack.toArray()));
    }
}