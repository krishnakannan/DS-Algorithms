/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

	List<NestedInteger> nestedList;
	Stack<ListIterator> stack;


    public NestedIterator(List<NestedInteger> nestedList) {        
        this.stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
		NestedInteger nInt = null;

		if (stack.peek().hasNext()) {
			nInt = (NestedInteger)stack.peek().next();
		}    			

		while (!stack.empty() && !stack.peek().hasNext()) {
				stack.pop();
			}
		return nInt.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty() && stack.peek().hasNext()) {
            NestedInteger nInt = (NestedInteger)stack.peek().next();            
            if (nInt != null && (nInt.isInteger())) {                
                stack.peek().previous();
                break;
            } else if (nInt != null && nInt.getList() != null && nInt.getList().size() > 0)  {            
                stack.push(nInt.getList().listIterator());
            }
            
            while (!stack.empty() && !stack.peek().hasNext()) {
                stack.pop();
            }
        }        
        return !stack.isEmpty() && stack.peek().hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */