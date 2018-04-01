public class Solution {
    public int[] constructRectangle(int area) {
        int[] rect = new int[2];
        double sqrt = Math.sqrt(area);
        int length = (int)Math.ceil(sqrt);
        int width = (int)Math.floor(sqrt);
        while (area % length != 0) {
        	length++;
        }
        while (area % width != 0) {
        	width--;
        }
        rect[0] = length;
        rect[1] = width;
        return rect;
    }
}