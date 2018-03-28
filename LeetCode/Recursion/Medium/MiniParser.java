/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
	
	public NestedInteger deserialize(String s) {        
		return processString(s.toCharArray(), 0, s.length() - 1);
	}

	public NestedInteger processString(char[] s, int start, int end) {
		
		if (start > end) {
			return null;
		}

		if (isNumber(s, start, end)) {
			NestedInteger number = new NestedInteger(getInt(s, start, end));            
			return number;
		} else  if (isFlatList(s, start, end)) {
			NestedInteger nestedInteger = new NestedInteger();
			List<Integer> list = processCurrentLevel(s, start, end);                        
			for (Integer listInteger : list) {
                if (listInteger != null) {
                    NestedInteger ni = new NestedInteger(listInteger);
				    nestedInteger.add(ni);    
                }
			}
			return nestedInteger;
		} 

		NestedInteger nestedInteger = new NestedInteger();
		int i = start;
		while (i <= end)  {            
			int nextLevelStart = i + 1;
			while (nextLevelStart <= end && s[nextLevelStart] != '[') {
				nextLevelStart++;
			}
			int nextLevelEnd = getLevelEnd(s, nextLevelStart, end);
			List<Integer> currentLevel = processCurrentLevel(s, i + 1, nextLevelStart - 1);
            
			for (Integer listInteger : currentLevel) {
                if (listInteger != null) {
                    NestedInteger ni = new NestedInteger(listInteger);
				    nestedInteger.add(ni);    
                }				
			}
			NestedInteger nextLevel = processString(s, nextLevelStart, nextLevelEnd);
			if (nextLevel != null) {
				nestedInteger.add(nextLevel);
			}            
			i = nextLevelEnd + 1;            
		}

		return nestedInteger;	

	}

	public boolean isFlatList(char[] s, int start, int end) {
		int index = start;
		while (index <= end) {
			if (s[index] == '[') {
				return false;
			}
		}
		return true;
	}

	public List<Integer> processCurrentLevel(char[] s, int start, int end) {
		String temp = "";
        
		int index = start;
		List<Integer> list = new ArrayList<>();        
		while (index <= end) {
            if (s[index] != ',' && s[index] != ']') {
				temp = temp + s[index];				
			} else {
				list.add(getInt(s, start, index - 1));
				index++;
				start = index;				
			}
			index++;
		}
		list.add(getInt(s, start, end - 1));
		return list;
	}


	public boolean isNumber(char[] s, int start, int end) {
		if (s[start] == '-') {
			start++;
		}
		int index = start;
		while (index <= end) {
			if (s[index] < '0' || s[index] > '9') {
				return false;
			}
            index++;
		}
		return true;
	}

	public Integer getInt(char[] s, int start, int end) {
        if (start > end) {
            return null;
        }
		boolean isNegative = false;
		if (s[start] == '-') {
			start++;
			isNegative = true;
		}
		int index = start;
		int value = 0;
		while (index <= end) {
			value *= 10;
			value += s[index] - '0';
			index++;
		}
		return isNegative ? -value : value;
	}

	public int getLevelEnd(char[] s, int start, int end) {
		Stack<Character> stack = new Stack<>();
		int index = start;
		while (index < end) {
			if (s[index] == '[') {
				stack.push('[');
			} else if (!stack.empty() && stack.peek() == '[' && s[index] == ']') {
				stack.pop();
			}
			if (stack.empty()) {
				return index;
			}
            index++;
		}
		return index - 1;
	}
}