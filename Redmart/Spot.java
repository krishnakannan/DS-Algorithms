package Redmart;

import static Redmart.Ski.map;

/**
 * Created by Krish on 10/23/17.
 */
public class Spot {
    private int value;
    private Coordinates coordinates;


    public Spot(int i, int j) {
        this.value = map[i][j];
        this.coordinates = new Coordinates(i, j);
    }

    public Spot(int value, Coordinates coordinates, boolean visited) {
        this.value = value;
        this.coordinates = coordinates;
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
