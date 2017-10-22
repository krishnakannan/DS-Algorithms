package Redmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krish on 10/22/17.
 */
public class SingaporeSki {
    List<Spot> startPoints;
    List<List<Integer>> paths = new ArrayList<>();
    int[][] map  = {{4,8,7,3}, {2,6,9,2}, {2,5,2,4}, {2,4,3,4}};
    int count = 0;
    public static void main(String args[]) {
        SingaporeSki singaporeSki = new SingaporeSki();

        singaporeSki.skiPath();
    }

    public void skiPath() {
        startPoints = new ArrayList<>();
        identifyStartPoints();
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

    }


    public List<Spot> tracePath (Spot spot, ArrayList<Spot> path) {
        path.add(spot);
        spot.visited = true;

//        for (Spot val : path) {
//            System.out.print(val.getValue() + " -> ");
//        }
        System.out.println();
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
        longestPath.addAll(findLongestPath(topPath, leftPath, rightPath, bottomPath));
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

    public List<Spot> findLongestPath (List<Spot>... spots) {
        int maxVal = Integer.MIN_VALUE;
        List<Spot> longestSpot = new ArrayList<>();
        for (List<Spot> spot : spots) {
            if (spot != null && maxVal < spot.size()) {
                maxVal = spot.size();
                longestSpot = new ArrayList<>(spot);
            }
        }
        return longestSpot;
    }

    class Spot {
        int value;
        Coordinates coordinates;
        boolean visited;

        public Spot(int i, int j) {
            this.value = map[i][j];
            this.coordinates = new Coordinates(i, j);
            this.visited = false;
        }

        public Spot(int value, Coordinates coordinates, boolean visited) {
            this.value = value;
            this.coordinates = coordinates;
            this.visited = visited;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    class Coordinates {
        private int i;

        private int j;

        public Coordinates(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int i() {
            return i;
        }

        public int j() {
            return j;
        }

    }

}
