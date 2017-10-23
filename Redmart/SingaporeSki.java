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
        List<Spot> idealPath = new ArrayList<>();
        for (Spot spot : startPoints) {
            List<Spot> path = tracePath(spot, new ArrayList<>());
            if (path != null && path.size() > idealPath.size()) {
                idealPath.clear();
                idealPath.addAll(path);
            } else if (path != null && path.size() == idealPath.size()) {
                if ((path.get(path.size() - 1).getValue() - path.get(0).getValue()) > idealPath.get(idealPath.size() - 1).getValue() - idealPath.get(0).getValue()) {
                    idealPath.clear();
                    idealPath.addAll(path);
                }
            }
        }
        System.out.println("RESULT");
        for (Spot val : idealPath) {
            System.out.print(val.getValue() + " <- ");
        }
        //   System.out.println("Total Steps = " + count);
        System.out.println();
        System.out.println("THE EMAIL ADDRESS IS");
        int pathLength = idealPath.size();
        int maxDrop = idealPath.get(idealPath.size() - 1).getValue() - idealPath.get(0).getValue();
        System.out.println(pathLength + "" + maxDrop + "@redmart.com");
    }


    public List<Spot> tracePath (Spot spot, ArrayList<Spot> path) {

        List<Spot> topPath = null;
        List<Spot> leftPath = null;
        List<Spot> rightPath = null;
        List<Spot> bottomPath = null;


        if (mem[spot.getCoordinates().i()][spot.getCoordinates().j()].hasPath()) {
            return mem[spot.getCoordinates().i()][spot.getCoordinates().j()].getPath();
        }
        count++;

        if (spot.getCoordinates().i() > 0 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i() - 1][spot.getCoordinates().j()]) {
            topPath = tracePath(new Spot(spot.getCoordinates().i() - 1, spot.getCoordinates().j()), new ArrayList<Spot>(path));
        }
        if (spot.getCoordinates().j() > 0 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i()][spot.getCoordinates().j() - 1]) {
            leftPath = tracePath(new Spot(spot.getCoordinates().i(), spot.getCoordinates().j() - 1), new ArrayList<Spot>(path));
        }
        if (spot.getCoordinates().j() < map.length - 1 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i()][spot.getCoordinates().j() + 1]) {
            rightPath = tracePath(new Spot(spot.getCoordinates().i(), spot.getCoordinates().j() + 1), new ArrayList<Spot>(path));
        }
        if (spot.getCoordinates().i() < map.length - 1 && map[spot.getCoordinates().i()][spot.getCoordinates().j()] > map[spot.getCoordinates().i() + 1][spot.getCoordinates().j()]) {
            bottomPath = tracePath(new Spot(spot.getCoordinates().i() + 1, spot.getCoordinates().j()), new ArrayList<Spot>(path));
        }

        if (isEndPoint(spot.getCoordinates().i(), spot.getCoordinates().j())) {
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()] = new Path(1, 0, new ArrayList<>(Arrays.asList(spot)), true);
        }

        List<Spot> tPath = new ArrayList<>(findLongestDeepestPath (topPath, leftPath, rightPath, bottomPath));

        path.addAll(tPath);
        path.add(spot);

        if (!mem[spot.getCoordinates().i()][spot.getCoordinates().j()].hasPath()) {
            mem[spot.getCoordinates().i()][spot.getCoordinates().j()] = new Path(path.size(), path.get(path.size() - 1).getValue() - path.get(0).getValue() , new ArrayList<>(path), true);

        } else if (mem[spot.getCoordinates().i()][spot.getCoordinates().j()].hasPath()) {
            if (mem[spot.getCoordinates().i()][spot.getCoordinates().j()].getPathLength() < path.size()) {
                mem[spot.getCoordinates().i()][spot.getCoordinates().j()] = new Path(path.size(), path.get(path.size() - 1).getValue() - path.get(0).getValue(), new ArrayList<>(path), true);

            } else if (mem[spot.getCoordinates().i()][spot.getCoordinates().j()].getPathLength() == path.size()) {

                if (mem[spot.getCoordinates().i()][spot.getCoordinates().j()].getPathDepth() < path.get(path.size() - 1).getValue() - path.get(0).getValue()) {
                    mem[spot.getCoordinates().i()][spot.getCoordinates().j()] = new Path(path.size(), path.get(path.size() - 1).getValue() - path.get(0).getValue(), new ArrayList<>(path), true);
                }
            }
        }
        return path;
    }


    public void identifyStartPoints() {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == 0 && j == 0) {
                    if (map[i][j] >= map[i][j + 1] && map[i][j] >= map[i + 1][j]) {
                        startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                    }
                } else if (i == 0 && j != 0) {
                    if (j == map.length - 1) {
                        if (map[i][j] >= map[i][j - 1] && map[i][j] >= map[i + 1][j]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    } else {
                        if (map[i][j] >= map[i][j + 1] && map[i][j] >= map[i][j - 1] && map[i][j] >= map[i + 1][j]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    }
                } else if (i != 0 && j == 0) {
                    if (i == map.length - 1) {
                        if (map[i][j] >= map[i - 1][j] && map[i][j] >= map[i][j + 1]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    } else {
                        if (map[i][j] >= map[i - 1][j] && map[i][j] >= map[i + 1][j] && map[i][j] >= map[i][j + 1]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    }
                } else if (i != 0 && j != 0) {
                    if (i == map.length - 1 && j == map.length - 1) {
                        if (map[i][j] >= map[i - 1][j] && map[i][j] >= map[i][j - 1]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    } else if (i == map.length - 1) {
                        if (map[i][j] >= map[i][j - 1] && map[i][j] >= map[i][j + 1] && map[i][j] >= map[i - 1][j]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    } else if (j == map.length - 1) {
                        if (map[i][j] >= map[i - 1][j] && map[i][j] >= map[i + 1][j] && map[i][j] >= map[i][j - 1]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    } else {
                        if (map[i][j] >= map[i - 1][j] && map[i][j] >= map[i + 1][j] && map[i][j] >= map[i][j - 1] && map[i][j] >= map[i][j + 1]) {
                            startPoints.add(new Spot(map[i][j], new Coordinates(i,j), false));
                        }
                    }
                }
            }
        }
    }

    public boolean isEndPoint(int i, int j) {
        if (i == 0 && j == 0) {
            if (map[i][j] < map[i][j + 1] && map[i][j] < map[i + 1][j]) {
                return true;
            }
        } else if (i == 0 && j != 0) {
            if (j == map.length - 1) {
                if (map[i][j] < map[i][j - 1] && map[i][j] < map[i + 1][j]) {
                    return true;
                }
            } else {
                if (map[i][j] < map[i][j + 1] && map[i][j] < map[i][j - 1] && map[i][j] < map[i + 1][j]) {
                    return true;
                }
            }
        } else if (i != 0 && j == 0) {
            if (i == map.length - 1) {
                if (map[i][j] < map[i - 1][j] && map[i][j] < map[i][j + 1]) {
                    return true;
                }
            } else {
                if (map[i][j] < map[i - 1][j] && map[i][j] < map[i + 1][j] && map[i][j] < map[i][j + 1]) {
                    return true;
                }
            }
        } else if (i != 0 && j != 0) {
            if (i == map.length - 1 && j == map.length - 1) {
                if (map[i][j] < map[i - 1][j] && map[i][j] < map[i][j - 1]) {
                    return true;
                }
            } else if (i == map.length - 1) {
                if (map[i][j] < map[i][j - 1] && map[i][j] < map[i][j + 1] && map[i][j] < map[i - 1][j]) {
                    return true;
                }
            } else if (j == map.length - 1) {
                if (map[i][j] < map[i - 1][j] && map[i][j] < map[i + 1][j] && map[i][j] < map[i][j - 1]) {
                    return true;
                }
            } else {
                if (map[i][j] < map[i - 1][j] && map[i][j] < map[i + 1][j] && map[i][j] < map[i][j - 1] && map[i][j] < map[i][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Spot> findLongestDeepestPath (List<Spot>... spots) {
        int maxVal = Integer.MIN_VALUE;
        List<Spot> longestSpot = new ArrayList<>();
        int maxDrop = 0;
        int endPointDrop = Integer.MAX_VALUE;
        for (List<Spot> spot : spots) {
            // If the spot is endpoint. Choose the lowest point
            if (spot != null && maxVal <= spot.size() && spot.size() == 1) {
                maxVal = spot.size();
                if (endPointDrop > spot.get(0).getValue()) {
                    endPointDrop = spot.get(0).getValue();
                    longestSpot = new ArrayList<>(spot);
                }
            } else if (spot != null && maxVal < spot.size()) {
                    maxVal = spot.size();
                    maxDrop = spot.get(spot.size() - 1).getValue() - spot.get(0).getValue();
                    longestSpot = new ArrayList<>(spot);
            } else if (spot != null && maxVal == spot.size()) {
                    if (maxDrop < spot.get(spot.size() - 1).getValue() - spot.get(0).getValue()) {
                        maxDrop = spot.get(spot.size() - 1).getValue() - spot.get(0).getValue();
                        longestSpot = new ArrayList<>(spot);
                    }
                }
            }
        return longestSpot;
        }

}
