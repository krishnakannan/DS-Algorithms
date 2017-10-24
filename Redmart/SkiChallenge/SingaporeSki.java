package Redmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Redmart.Ski.map;
import static Redmart.Ski.mem;


/**
 * Created by Krish on 10/22/17.
 *
 *  METHOD USED - MEMOIZATION - Time Complexity - O(Total Points in Map) == O (n * n)
 *
 *      1. Identify the start points.
 *          a. A start point is a point in the map that cannot be reached from any directions
 *          (It will always be a higher altitude than its neighbours).
 *      2. For all start points
 *          a. Recursively trace the "Longest" and "Deepest" distance that can be reached.
 *          b. Memoize the traced path that can be used for later calculation.
 *      3. Print the found "Longest" and "Deepest" distance.
 *
 */


public class SingaporeSki {
    List<Spot> startPoints;
    int count = 0;
    int prevLong = -1;
    public static void main(String args[]) {
        SingaporeSki singaporeSki = new SingaporeSki();
        System.out.println("BEGIN");
        Ski.readMap();
        //Ski.initPath();
        if (map.length == 0) {
            System.out.println("PROBLEM IN INPUT");
            return;
        }
        System.out.println("READ INPUT");
        singaporeSki.skiPath();
    }

    public void skiPath() {
        startPoints = new ArrayList<>();
        System.out.println("IDENTIFYING START POINTS");
        identifyStartPoints();
        System.out.println("IDENTIFIED START POINTS");
        Spot idealPath = new Spot();
        for (Spot spot : startPoints) {
            Spot path = tracePath(spot);
            if (path != null && path.getPathLength() > idealPath.getPathLength()) {
                idealPath = path;
            } else if (path != null && path.getPathLength() == idealPath.getPathLength()) {
                if ((path.getPathDepth() > idealPath.getPathDepth())) {
                    idealPath = path;
                }
            }
        }
        System.out.println("RESULT");
        printPath(idealPath);
        System.out.println();
        System.out.println("THE EMAIL ADDRESS IS");
        int pathLength = idealPath.getPathLength();
        int maxDrop = idealPath.getPathDepth();
        System.out.println(pathLength + "" + maxDrop + "@redmart.com");

    }


    public Spot tracePath (Spot spot) {

        Spot topPath = null;
        Spot leftPath = null;
        Spot rightPath = null;
        Spot bottomPath = null;


        if (mem[spot.getCoordinates().i()][spot.getCoordinates().j()].hasPath()) {
            return mem[spot.getCoordinates().i()][spot.getCoordinates().j()];
        }
        count++;

        if (spot.getCoordinates().i() > 0 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i() - 1][spot.getCoordinates().j()]) {
            topPath = tracePath(new Spot(spot.getCoordinates().i() - 1, spot.getCoordinates().j()));
        }
        if (spot.getCoordinates().j() > 0 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i()][spot.getCoordinates().j() - 1]) {
            leftPath = tracePath(new Spot(spot.getCoordinates().i(), spot.getCoordinates().j() - 1));
        }
        if (spot.getCoordinates().j() < map.length - 1 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i()][spot.getCoordinates().j() + 1]) {
            rightPath = tracePath(new Spot(spot.getCoordinates().i(), spot.getCoordinates().j() + 1));
        }
        if (spot.getCoordinates().i() < map.length - 1 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i() + 1][spot.getCoordinates().j()]) {
            bottomPath = tracePath(new Spot(spot.getCoordinates().i() + 1, spot.getCoordinates().j()));
        }

        if (isEndPoint(spot.getCoordinates().i(), spot.getCoordinates().j())) {
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()].setHasPath(true);
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()].setPathLength(1);
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()].setPathDepth(0);
            return mem[spot.getCoordinates().i()][spot.getCoordinates().j()];
        }

        Spot tPath = findLongestDeepestPath (spot, topPath, leftPath, rightPath, bottomPath);
        spot.setPathLength(tPath.getPathLength() + 1);
        spot.setPathDepth(spot.getValue() - tPath.getValue() + tPath.getPathDepth());




        if (!mem[spot.getCoordinates().i()][spot.getCoordinates().j()].hasPath()) {
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()].setHasPath(true);
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()].setPathDepth(spot.getPathDepth());
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()].setPathLength(spot.getPathLength());
        } 
        
        return mem[spot.getCoordinates().i()][spot.getCoordinates().j()];
    }


    public void identifyStartPoints() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                boolean greaterThanSurrounding = true;
                if (i > 0) {
                    greaterThanSurrounding = greaterThanSurrounding && (map[i][j] >= map[i-1][j]);
                }
                if (j > 0) {
                    greaterThanSurrounding = greaterThanSurrounding && (map[i][j] >= map[i][j-1]);
                }
                if (i < map.length-1) {
                    greaterThanSurrounding = greaterThanSurrounding && (map[i][j] >= map[i+1][j]);
                }
                if (j < map.length-1) {
                    greaterThanSurrounding = greaterThanSurrounding && (map[i][j] >= map[i][j+1]);
                }
                if (greaterThanSurrounding) {
                    startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                }
            }
        }
    }

    public boolean isEndPoint(int i, int j) {
        boolean lessThanSurrounding = true;
        if (i > 0) {
            lessThanSurrounding = lessThanSurrounding && (map[i][j] <= map[i-1][j]);
        }
        if (j > 0) {
            lessThanSurrounding = lessThanSurrounding && (map[i][j] <= map[i][j-1]);
        }
        if (i < map.length-1) {
            lessThanSurrounding = lessThanSurrounding && (map[i][j] <= map[i+1][j]);
        }
        if (j < map.length-1) {
            lessThanSurrounding = lessThanSurrounding && (map[i][j] <= map[i][j+1]);
        }
        return lessThanSurrounding;
    }

    public Spot findLongestDeepestPath (Spot... spots) {
        int longestPath = Integer.MIN_VALUE;
        Spot longestSpot = null;
        int deepestDrop = 0;
        int endPointDrop = Integer.MAX_VALUE;
        for (Spot spot : spots) {
            // If the spot is endpoint. Choose the lowest point
            if (spot != null && longestPath <= spot.getPathLength() && spot.getPathLength() == 1) {
                longestPath = spot.getPathLength();
                if (endPointDrop > spot.getValue()) {
                    endPointDrop = spot.getValue();
                    longestSpot = spot;
                }
            }
            
            if (spot != null && longestPath < spot.getPathLength()) {
                    longestPath = spot.getPathLength();
                    deepestDrop = spot.getPathDepth();
                    longestSpot = spot;
            } else if (spot != null && longestPath == spot.getPathLength()) {
                    if (deepestDrop < spot.getPathDepth()) {
                        deepestDrop = spot.getPathDepth();
                        longestSpot = spot;
                    }
                }
            }
        return longestSpot;
    }

    public Spot getLongestDeepestPath(Spot... spots) {
        int longestPath = Integer.MIN_VALUE;
        Spot longestSpot = null;
        int spotVal = Integer.MAX_VALUE;
        int deepestDrop = 0;
        for (Spot spot : spots) {
            if (spot.getValue() >= prevLong) {
                continue;
            } else if (spot != null && longestPath < spot.getPathLength()) {
                longestPath = spot.getPathLength();
                deepestDrop = spot.getPathDepth();
                longestSpot = spot;
                spotVal = spot.getValue();
            } else if (spot != null && longestPath == spot.getPathLength()) {
                if (deepestDrop < spot.getPathDepth()) {
                    deepestDrop = spot.getPathDepth();
                    longestSpot = spot;
                    spotVal = spot.getValue();
                } /* If the spot is endpoint. Choose the lowest point */
                else if (deepestDrop == spot.getPathDepth()) {
                    if (spotVal > spot.getValue()) {
                        deepestDrop = spot.getPathDepth();
                        longestSpot = spot;
                        spotVal = spot.getValue();
                    }
                }

            }
        }
        return longestSpot;
    }

    public void printPath(Spot spot) {
        int length = spot.getPathLength();
        while(--length >= 0) {
            System.out.print(spot.getValue() + " -> ");
            prevLong = spot.getValue();
            spot = getLongestDeepestPath(spot.getCoordinates().j() > 0 ? mem[spot.getCoordinates().i()][spot.getCoordinates().j() - 1] : null, spot.getCoordinates().i() > 0 ? mem[spot.getCoordinates().i() - 1][spot.getCoordinates().j()] : null, spot.getCoordinates().i() < mem.length ? mem[spot.getCoordinates().i() + 1][spot.getCoordinates().j()] : null, spot.getCoordinates().j() < mem.length ? mem[spot.getCoordinates().i()][spot.getCoordinates().j() + 1] : null);

        }
    }


}
