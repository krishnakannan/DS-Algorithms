/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

//http://practice.geeksforgeeks.org/problems/binary-search/1

class GfG
{
	int bin_search(int A[], int left, int right,  int k) {
		if (left > right) {
			return -1;
		}
		int middle = left == 0 ? (right - left) / 2 : ((right - left) / 2) + left;
		if (k == A[middle]) {
			return middle;
		} else if (k > A[middle]) {
			return bin_search(A, middle + 1, right, k);
		} else {
			return bin_search(A, left, middle - 1, k);
		}
	}
}