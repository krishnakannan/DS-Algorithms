class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length = 0;
        int breadth = 0;
        boolean isIntersectCompletely = false;
        
        int lx1;
        int ly1;
        int lx2;
        int ly2;
        
        int rx1;
        int ry1;
        int rx2;
        int ry2;
     
        //Identifying Left and Right Rectangles;
        if (E >= A) {
            lx1 = A;
            ly1 = B;
            lx2 = C;
            ly2 = D;
            rx1 = E;
            ry1 = F;
            rx2 = G;
            ry2 = H;
        } else {
            lx1 = E;
            ly1 = F;
            lx2 = G;
            ly2 = H;
            rx1 = A;
            ry1 = B;
            rx2 = C;
            ry2 = D;
        }
        //System.out.println("lx1 " + lx1 + " ly1 " + ly1 + " lx2 " + lx2 + " ly2 " + ly2 + " rx1 " + rx1 + " ry1 " + ry1 + " rx2 " + rx2 + " ry2 " + ry2);
        //Find if they intersect
        if ((ry1 >= ly2) || (rx1 >= lx2) || (ly1 >= ry2)) {
            //Doesn't Intersect
            length = 0;
            breadth = 0;            
            // System.out.println("DOESNT INTERSECT");
        } else if (lx1 < rx1 && lx2 > rx2 && ly1 < ry1 && ly2 > ry2) {
            //Intersect Completely
            length = 0;
            breadth = 0;
            isIntersectCompletely = true;
        } else {
            //Partial Intersect
            if (rx2 > lx2) {
                length = lx2 - rx1;
            } else {
                length = rx2 - rx1;
            }
            
            if (ly2 > ry2) {          
                if (ry1 < ly1) {
                    breadth = ry2 - ly1;    
                } else {
                    breadth = ry2 - ry1;
                }
                
            } else {      
                if (ly1 < ry1) {
                    breadth = ly2 - ry1;
                } else {
                    breadth = ly2 - ly1;    
                }
                
            }
        }
        
        int intersectingArea = length * breadth;
        int area1 = (lx2 - lx1) * (ly2 - ly1);
        int area2 = (rx2 - rx1) * (ry2 - ry1);
        int totalArea;
        if (isIntersectCompletely) {
            totalArea = area1 > area2 ? area1 : area2;
        } else {
            totalArea = area1 + area2 - intersectingArea;   
        }
        
//          System.out.println("Length. " + length + " Breadth " + breadth);
        
//          System.out.println("Area1 " + area1 + " Area2 " + area2 + " intersectingArea " + intersectingArea + " totalArea " + totalArea);
        
        return totalArea;
        
    }
}