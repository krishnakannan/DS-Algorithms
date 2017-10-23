package Redmart;

import java.util.ArrayList;
import java.util.List;

import static Redmart.Ski.map;


/**
 * Created by Krish on 10/22/17.
 *
 *  METHOD USED
 *
 *      1. Identify the start points.
 *          a. A start point is a point in the map that cannot be reached from any directions
 *          (It will always be a higher altitude than its neighbours).
 *      2. For all start points
 *          a. Recursively trace the "Longest" and "Deepest" distance that can be reached.
 *      3. Print the found "Longest" and "Deepest" distance
 *
 */


public class SingaporeSki {
    List<Spot> startPoints;

    public static void main(String args[]) {
        SingaporeSki singaporeSki = new SingaporeSki();
        System.out.println("BEGIN");
        Ski.readMap();
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
                if ((path.get(0).getValue() - path.get(path.size() - 1).getValue()) > idealPath.get(0).getValue() - idealPath.get(idealPath.size() - 1).getValue()) {
                    idealPath.clear();
                    idealPath.addAll(path);
                }
            }
        }
        System.out.println("RESULT");
        for (Spot val : idealPath) {
            System.out.print(val.getValue() + " -> ");
        }
        System.out.println();
        System.out.println("THE EMAIL ADDRESS IS");
        int pathLength = idealPath.size();
        int maxDrop = idealPath.get(0).getValue() - idealPath.get(idealPath.size() - 1).getValue();
        System.out.println(pathLength + "" + maxDrop + "@redmart.com");

    }


    public List<Spot> tracePath (Spot spot, ArrayList<Spot> path) {
        path.add(spot);
        List<Spot> topPath = null;
        List<Spot> leftPath = null;
        List<Spot> rightPath = null;
        List<Spot> bottomPath = null;

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

        List<Spot> longestPath = new ArrayList<>();
        longestPath.addAll(findLongestDeepestPath (topPath, leftPath, rightPath, bottomPath));


        if (path.size() < longestPath.size()) {
            path.clear();
            path.addAll(longestPath);
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

    public List<Spot> findLongestDeepestPath (List<Spot>... spots) {
        int maxVal = Integer.MIN_VALUE;
        List<Spot> longestSpot = new ArrayList<>();
        int maxDrop = 0;
        for (List<Spot> spot : spots) {
            if (spot != null && maxVal < spot.size()) {
                maxVal = spot.size();
                maxDrop = spot.get(0).getValue() - spot.get(spot.size() - 1).getValue();
                longestSpot = new ArrayList<>(spot);
            } else if (spot != null && maxVal == spot.size()) {
                if (maxDrop < spot.get(0).getValue() - spot.get(spot.size() - 1).getValue()) {
                    maxDrop = spot.get(0).getValue() - spot.get(spot.size() - 1).getValue();
                    longestSpot = new ArrayList<>(spot);
                }
            }
        }
        return longestSpot;
    }
}
