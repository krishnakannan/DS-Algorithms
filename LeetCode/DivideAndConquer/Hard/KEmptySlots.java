import java.util.*;
import java.lang.*;   
import java.io.*;

class KEmptySlots {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		KEmptySlots kes = new KEmptySlots();
		int n = in.nextInt();
		int[] flowers = new int[n];
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = in.nextInt();
		}
		int k = in.nextInt();
		System.out.println(kes.kEmptySlots(flowers, k));
	}

	//USING BST

	class TreeNode {
		int val;
		int prev = 0;
		int next = 0;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.val = value;
		}
	}

    public int kEmptySlots(int[] flowers, int k) {
    	if (flowers.length == 0) {
    		return -1;
    	}
		TreeNode root = insertNode(null, flowers[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
        //System.out.println("Inserted " + root.val + " Prev " + root.prev + " Next " + root.next);
		for (int i = 1; i < flowers.length; i++) {
			TreeNode insertedNode = insertNode(root, flowers[i], Integer.MIN_VALUE, Integer.MAX_VALUE);
            //System.out.println("Inserted " + insertedNode.val + " Prev " + insertedNode.prev + " Next " + insertedNode.next);
			if ((flowers[i] - insertedNode.prev - 1) == k) {
				return i + 1;
			} else if ((insertedNode.next - flowers[i] - 1) == k) {
				return i + 1;
			}
		} 		       
		return -1;
    }

    public TreeNode insertNode(TreeNode root, int value, int prev, int next) {
    	if (root == null) {
    		TreeNode node = new TreeNode(value);
    		node.prev = prev;
    		node.next = next;
    		return node;
    	}

    	if (value > root.val) {
    		prev = root.val;
    		if (root.right == null) {
    			TreeNode node = new TreeNode(value);
    			node.prev = prev;
    			node.next = next;
                root.right = node;
    			return node;
    		} else {
    			return insertNode(root.right, value, prev, next);
    		}
    	} else {
			next = root.val;
			if (root.left == null) {
				TreeNode node = new TreeNode(value);
				node.prev = prev;
				node.next = next;
                root.left = node;
				return node;
			} else {
				return insertNode(root.left, value, prev, next);
			}
    	}
    }
} 