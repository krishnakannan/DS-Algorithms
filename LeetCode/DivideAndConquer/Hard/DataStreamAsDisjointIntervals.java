/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

	//Solving Using BST;

	class TreeNode {
		int start;
		int end;
		TreeNode left;
		TreeNode right;
		public TreeNode(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	TreeNode root;
	List<Interval> intervals;

	/** Initialize your data structure here. */
	public SummaryRanges() {
		root = null;
		intervals = new ArrayList<>();
	}
	
	public void addNum(int val) {
		if (root == null) {
			root = new TreeNode(val, val);
			return;
		} else {
			traverseAndMerge(root, val);
		}
	}
	


	public List<Interval> getIntervals() {
		intervals.clear();
		inOrderTraverse(root);
		return intervals;
	}

	public void inOrderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
            intervals.add(new Interval(root.start, root.end));	
			return;
		}

		inOrderTraverse(root.left);
        intervals.add(new Interval(root.start, root.end));
		inOrderTraverse(root.right);
	}    
    
	public TreeNode traverseAndMerge(TreeNode root, int val) {
	
        if (root == null) {            
            root = new TreeNode(val, val);
            return root;
        }
        
        //Check inorder predecessor
        if(val == root.start - 1){
            root.start = val;
            if(root.left != null){
                TreeNode predecessor = root.left;
                TreeNode parent = root;                
                while (predecessor.right != null) {
                    parent = predecessor;
                    predecessor = predecessor.right;
                }
                
                if (root.start == predecessor.end + 1){
                    if (parent == root) {
                        root.start = predecessor.start;
                        root.left = predecessor.left;
                    } else {
                        root.start = predecessor.start;
                        parent.right = predecessor.left;
                    }
                }
            }
	    //Check the Inorder Successor
        } else if (val == root.end + 1){
            root.end = val;
            if(root.right != null){
                TreeNode successor = root.right;
                TreeNode parent = root;
                while(successor.left != null){
                    parent = successor;
                    successor = successor.left;
                }
                if (root.end == successor.start - 1){
                    if (parent == root) {
                        root.end = successor.end;
                        root.right = successor.right;
                    } else {
                        root.end = successor.end;
                        parent.left = successor.right;
                    }
                }
            }
        } else if (val > root.end + 1) {
            root.right = traverseAndMerge(root.right, val);
        } else if (val < root.start - 1) {
            root.left = traverseAndMerge(root.left, val);
        }
	    return root;
	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */