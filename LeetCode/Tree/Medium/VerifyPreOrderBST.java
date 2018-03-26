class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean verify(int[] nodes, int start, int end, int min, int max) {
    	if (start > end) {
    		return true;
    	}

    	int root = nodes[start];

		if (root > max || root < min) {
			return false;
		}

    	//Split Left and Right Subtrees.
    	int splitIndex = start;
    	while (splitIndex <= end && nodes[splitIndex] <= root) {
    		splitIndex++;
    	}

    	return verify(nodes, start + 1, splitIndex - 1, min, root)
    			&& verify(nodes, splitIndex, end, root, max);

    }
}