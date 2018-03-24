class Solution {
    
    /*
        
        Few Mathematical things to remember.
        
        Point P is given by co-ordinates = (x, y);
        
        A vector between two points P1 and P2 is ((x2 - x1), (y2 - y1));
        
        So A vector is represented as (a, b);
        
        Cross Product between two vectors V1 and V2 of 2 dimension is 
        
        V1 x V2 = (a1 * b2) - (b1 * a2)
        
        Therefore given three co-ordinates (x1, y1) (x2, y2) (x3, y3)
        
        V1 = (x2 - x1), (y2 - y1);
        V2 = (x3 - x2), (y3 - y2);
        
        V1 x V2 = (x2 - x1) * (y3 - y2) - (x3 - x2) * (y2 - y1);
        
        //Referred property.
        
        If we draw a convex polygon in counter clockwise direction all the Vector cross product between three co-ordinates
        should be less than or equal to 0, it will be greater than or equal to zero if we draw it in clockwise direction;
        
    */
    
    public boolean isConvex(List<List<Integer>> points) {
        int totalPoints = points.size();
        
        boolean positivePresent = false;
        boolean negativePresent = false;

        
        for (int p1 = 0; p1 < totalPoints; p1++) {            
            int p2 = (p1 + 1) % totalPoints;
            int p3 = (p2 + 1) % totalPoints;            

            int crossProduct = getCrossProduct(points.get(p1).get(0), points.get(p2).get(0), points.get(p3).get(0), points.get(p1).get(1), points.get(p2).get(1), points.get(p3).get(1));

            if (crossProduct < 0) {
                negativePresent = negativePresent | true;
            }

            if (crossProduct > 0) {
                positivePresent = positivePresent | true;
            }

            if (positivePresent && negativePresent) {
                return false;
            }
            
        }
        
       return true;
    }
    
    
    public int getCrossProduct(int x1, int x2, int x3, int y1, int y2, int y3) {
        return ((x2 - x1) * (y3 - y2)) - ((x3 - x2) * (y2 - y1));
    }
}