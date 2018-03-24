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
class Solution {
    
    class Entry {
        Integer val;
        Integer depth;
        public Entry(Integer val, Integer depth) {
            this.val = val;
            this.depth = depth;
        }
    }    
    
    int maxDepth = Integer.MIN_VALUE;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Entry> entries = new ArrayList<>();
        dfs(nestedList, entries, null, 0);
        int sum = 0;
        for (Entry entry : entries) {
            sum = sum + ((maxDepth - entry.depth + 1) * entry.val);
        }
        
        return sum;
            
    }
    
    public void dfs (List<NestedInteger> nestedList, List<Entry> entries, NestedInteger currentInteger, int depth) {
        if (currentInteger != null && currentInteger.isInteger()) {
            entries.add(new Entry(currentInteger.getInteger(), depth));
            maxDepth = maxDepth < depth ? depth : maxDepth;
            return; 
        }
        
        if (nestedList != null) {
            for (NestedInteger nInteger : nestedList) {
                dfs(nInteger.getList(), entries, nInteger, depth + 1);    
            }
        }                
    }
    
    public void printEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println("[" + entry.val + " => " + entry.depth + "]");
        }
        System.out.println();
    }
    
}