package Redmart;

import static Redmart.Ski.map;

/**
 * Created by Krish on 10/23/17.
 */
public class Spot {
    private int value;
    private Coordinates coordinates;
    private int pathLength;
    private int pathDepth;
    private boolean hasPath = false;

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }

    public int getPathDepth() {
        return pathDepth;
    }

    public void setPathDepth(int pathDepth) {
        this.pathDepth = pathDepth;
    }

    public boolean hasPath() {
        return hasPath;
    }

    public void setHasPath(boolean hasPath) {
        this.hasPath = hasPath;
    }

    public Spot() {

    }

    public Spot(int i, int j) {
        this.value = map[i][j];
        this.coordinates = new Coordinates(i, j);
    }

    public Spot(int value, Coordinates coordinates, boolean hasPath) {
        this.value = value;
        this.coordinates = coordinates;
        this.hasPath = hasPath;
        this.pathDepth = 0;
        this.pathLength = 1;
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
}
