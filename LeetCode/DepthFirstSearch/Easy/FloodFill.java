class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {    
    	fill(image, sr, sc, image[sr][sc], newColor);
    	return image;
    }

	public void fill(int[][] image, int row, int col, int oldColor, int newColor) {
		//End Condition
		//Bounds check
		if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
			return;
		}

		//Check already filled or Other color
		if (image[row][col] == newColor) {
			return;
		}
		if (image[row][col] != oldColor) {
			return;
		}

		image[row][col] = newColor;

		fill(image, row - 1, col, oldColor, newColor);
		fill(image, row + 1, col, oldColor, newColor);
		fill(image, row, col + 1, oldColor, newColor);
		fill(image, row, col - 1, oldColor, newColor);

	}
}