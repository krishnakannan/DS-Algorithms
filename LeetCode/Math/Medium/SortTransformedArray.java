// Applying f(x) = ax^2 + bx + c to every element and returned sorted Array.

/*
	The Algorithm is O(n);

	ax^2 + bx + c is a quadratic equation which is also a standard form of expressing a Parabola

	Parabola is a curve and 

		if "a" is positive the parabola will be high-low-high

		if "a" is negative the parabola will be low-high-low

		with this we solve this problem.


*/

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    	int left = 0;
    	int right = nums.length - 1;
    	int[] res = new int[nums.length];

        int index = a > 0 ? right : left;
		while (left < right) {
			int lVal = quadraticSolver(nums[left], a, b, c);
			int rVal = quadraticSolver(nums[right], a, b, c);
			if (a > 0) {
				if (lVal > rVal) {
					res[index] = lVal;
					left++;    				
				} else {
					res[index] = rVal;
					right--;
				}				
			} else {
				if (lVal > rVal) {
					res[index] = rVal;
					right--;    				
				} else {
					res[index] = lVal;
					left++;
				}
			}
			
			index = a > 0 ? index - 1 : index + 1;
		}
		if (left == right) {
			res[index] = quadraticSolver(nums[left], a, b, c);
		}

		return res;
    }


    public int quadraticSolver(int x, int a, int b, int c) {
    	//ax^2 + bx + c 
    	return (a * (x * x)) + (b * x) + c;

    }
}