class Solution {
	
	//Brute Force Soln N ^ 2

	class Box {
        int index;
        int start;
        int end;
        int height;
        public Box(int index, int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
            this.index = index;
        }
    }

    TreeSet<Box> boxSet;
    int maxHeight = Integer.MIN_VALUE;

    public List<Integer> fallingSquares(int[][] positions) {
        boxSet = new TreeSet<>(new Comparator<Box>(){
            public int compare(Box a, Box b) {
                return b.height - a.height;
            }
        });

        List<Integer> maxHeights = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            int maxHeight = updateSet(positions[i][0], positions[i][1], i);
            maxHeights.add(maxHeight);
        }
        return maxHeights;
    }


    public int updateSet(int start, int size, int index) {
        int end = start + size;
        int height = size;
        int tallestSoFar = 0;
        boolean baseFound = false;

        //Search for the base;
        for (Box box : boxSet) {
            if (start < box.end && end > box.start) {
                tallestSoFar = box.height > tallestSoFar ? box.height : tallestSoFar;
                break;
            }
        }
        height += tallestSoFar;
        Box newBox = new Box(index, start, end, height);
        boxSet.add(newBox);
        calcMaxHeight(newBox);
        return maxHeight;

    }

    public void calcMaxHeight(Box box) {
        int height = box.height;
        maxHeight = maxHeight < height ? height : maxHeight;
    }
}

