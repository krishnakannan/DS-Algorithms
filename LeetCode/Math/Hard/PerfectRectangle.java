class PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) {
            return true;
        }
		Map<String, Integer> corners = new HashMap<>();
        Set<String> rectangleSet = new HashSet<>();
        int totalArea = 0;
		for (int[] rectangle : rectangles) {
            totalArea += ((rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]));
			String bottomLeft = rectangle[0] + "," + rectangle[1];
			String topRight = rectangle[2] + "," + rectangle[3];
			String bottomRight = rectangle[2] + "," + rectangle[1];
			String topLeft = rectangle[0] + "," + rectangle[3];
            String rect = bottomLeft + "," + topRight + "," + bottomRight + "," + topLeft;
            if (!rectangleSet.add(rect)) {
                //Complete overlap / a duplicate rectangle
                return false;
            }
			corners.put(bottomLeft, corners.containsKey(bottomLeft) ? corners.get(bottomLeft) + 1 : 1);
			corners.put(bottomRight, corners.containsKey(bottomRight) ? corners.get(bottomRight) + 1 : 1);
			corners.put(topLeft, corners.containsKey(topLeft) ? corners.get(topLeft) + 1 : 1);
			corners.put(topRight, corners.containsKey(topRight) ? corners.get(topRight) + 1 : 1);
		}         
        List<int[]> boundaryRectangle = new ArrayList<>();
        //System.out.println(corners);
        
		int singleOccurences = 0;
        int index = 0;
		for (Map.Entry<String, Integer> entry : corners.entrySet()) {
            int occurence = entry.getValue();
            String[] coord = entry.getKey().split(",");
            if (occurence == 1) {
                singleOccurences += 1;                
                boundaryRectangle.add(new int[]{Integer.parseInt(coord[0]), Integer.parseInt(coord[1])});                
            }			
		}
        
        if (boundaryRectangle.size() != 4) {
            return false;
        }
        
        
        int length = 0;
        int breadth = 0;
        if (boundaryRectangle.get(0)[0] != boundaryRectangle.get(1)[0]) {
            length = diff(boundaryRectangle.get(0)[0], boundaryRectangle.get(1)[0]);
        } else {
            length = diff(boundaryRectangle.get(0)[0], boundaryRectangle.get(2)[0]);
        }
        
        if (boundaryRectangle.get(0)[1] != boundaryRectangle.get(1)[1]) {
            breadth = diff(boundaryRectangle.get(0)[1], boundaryRectangle.get(1)[1]);
        } else {
            breadth = diff(boundaryRectangle.get(0)[1], boundaryRectangle.get(2)[1]);
        }
        
        int boundaryArea = length * breadth;
        //System.out.println("Total Area " + totalArea + " Boundary Area " + boundaryArea);
		return singleOccurences == 4 && boundaryArea == totalArea;
    }
    
    public int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }
}