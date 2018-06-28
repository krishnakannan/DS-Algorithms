class Solution {
    //Area = ABS (Ax(By - Cy) + Bx(Cy -Ay) + Cx(Ay - By) / 2)
    public double largestTriangleArea(int[][] points) {
        double largestArea = 0d;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double area = getArea(points[i], points[j], points[k]);
                    largestArea = area > largestArea ? area : largestArea;
                }
            }
        }
        return largestArea;
    }
    
    public double getArea(int[] A, int[] B, int[] C) {
        return Math.abs(((double)((A[0] * (B[1] - C[1])) + (B[0] * (C[1] - A[1])) + (C[0] * (A[1] - B[1]))) / 2));
    }
}