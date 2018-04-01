class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowCount = triangle.size();
        List<Integer> currentRow = new ArrayList<>();
        List<Integer> nextRow = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rowCount; i++) {
            currentRow.addAll(triangle.get(i));
            int rowLength = currentRow.size();
            if (i < rowCount - 1) {
                nextRow.addAll(triangle.get(i + 1));
                for (int j = 0; j < rowLength; j++) {
                    if (j == 0) {
                        
                        triangle.get(i + 1).set(j, triangle.get(i + 1).get(j) + currentRow.get(j));
                    } else {
                        if (currentRow.get(j) + nextRow.get(j) < triangle.get(i + 1).get(j)) {
                            triangle.get(i + 1).set(j, currentRow.get(j) + nextRow.get(j));
                        }
                    }
                    triangle.get(i + 1).set(j + 1, triangle.get(i + 1).get(j + 1) + currentRow.get(j));
                }
            }
            currentRow.clear();
            nextRow.clear();
        }
        
        for (Integer x : triangle.get(rowCount - 1)) {
            if (min > x) {
                min = x;
            }
        }
        return min;
    }
}