/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

	// Column is maintained in TreeMap
	// Levels need to be maintained.
	// We use a int[] to store value and level
	// node[0] = value;
	// node[1] = level;
	// Sort by level;

	TreeMap<Integer, List<int[]>> vMap = new TreeMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {

    	List<List<Integer>> vOrder = new ArrayList<>();
        
        traverse(root, 0, 0);
        
        for (Map.Entry<Integer, List<int[]>> entry : vMap.entrySet()) {
        	Collections.sort(entry.getValue(), new Comparator<int[]>(){
        		public int compare(int[] a, int[] b) {
        			return a[1] - b[1];
        		}
        	});
            
            List<Integer> ivOrder = new ArrayList<>();
            
            for (int[] eachValue : entry.getValue()) {
                ivOrder.add(eachValue[0]);
            }
        	
            vOrder.add(ivOrder);
        }

        return vOrder;
    }

	//	PRE ORDER

    public void traverse(TreeNode root, int column, int level) {
    	if (root == null) {
    		return;
    	}

    	if (root.left == null && root.right == null) {
    		if (!vMap.containsKey(column)) {
    			vMap.put(column, new ArrayList<>());
    		}
    		vMap.get(column).add(new int[]{root.val, level});
    		return;
    	}

    	if (!vMap.containsKey(column)) {
			vMap.put(column, new ArrayList<>());
		}
		vMap.get(column).add(new int[]{root.val, level});	

		traverse(root.left, column - 1, level + 1);
		traverse(root.right, column + 1, level + 1);
    }
}