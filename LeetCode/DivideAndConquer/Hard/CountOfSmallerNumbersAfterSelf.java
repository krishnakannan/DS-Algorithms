import java.util.*;
import java.lang.*;   
import java.io.*;

class CountOfSmallerNumbersAfterSelf {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		CountOfSmallerNumbersAfterSelf csnas = new CountOfSmallerNumbersAfterSelf();
		System.out.println(csnas.countSmaller(nums));
	}

	//Building BST Method;

	class TreeNode {
		int val;
		int smaller = 1;
		TreeNode left;
		TreeNode right;
		public TreeNode(int value) {
			this.val = value;
		}
	}

    public List<Integer> countSmaller(int[] nums) {
    	List<Integer> smaller = new ArrayList<>();
    	TreeNode root = new TreeNode(nums[nums.length - 1]);
    	smaller.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
        	int smallerThanThis = insertNode(root, nums[i], 0);
        	smaller.add(smallerThanThis);
        }
        Collections.reverse(smaller);
        return smaller;
    }


    public int insertNode(TreeNode root, int newValue, int smallerThanThis) {
    	if (root.val > newValue) {
    		root.smaller += 1;    		
			if (root.left == null) {
				root.left = new TreeNode(newValue);
				root.smaller = smallerThanThis;
				return smallerThanThis;
			} else {
				return insertNode(root.left, newValue, smallerThanThis);
			}    		
    	} else {
    		smallerThanThis += root.smaller;
    		if (root.right == null) {
    			root.right = new TreeNode(newValue);
    			root.smaller = smallerThanThis;
    			return smallerThanThis;
    		} else {
    			return insertNode(root.right, newValue, smallerThanThis);
    		}
    	}
    }
}

/*
	
	SLOWER O(N ^ 2);

	Integer[] smaller;
    public List<Integer> countSmaller(int[] nums) {
        smaller = new Integer[nums.length];
        Arrays.fill(smaller, 0);
        split(nums, 0, nums.length - 1);
        return Arrays.asList(smaller);
    }

    public void split(int[] nums, int start, int end) {
    	if (start > end) {
    		return;
    	}

    	if (start == end) {
    		smaller[start] = 0;
    		return;
    	}
    	int middle = start + ((end - start) / 2);
    	split(nums, start, middle);
    	split(nums, middle + 1, end);
    	computeSmaller(nums, start, middle, end);
    }

    public void computeSmaller(int nums[], int start, int middle, int end) {
    	for (int i = start; i <= middle; i++) {
    		for (int j = middle + 1; j <= end; j++) {
    			if (nums[i] > nums[j]) {
    				smaller[i] += 1;
    			}
    		}
    	}
    }
*/