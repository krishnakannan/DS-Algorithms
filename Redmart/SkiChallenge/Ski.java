package Redmart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Krish on 10/23/17.
 */
public class Ski {
    public static int[][] map;
    public static Spot[][] mem;

//    public static int[][] map  = {{4,8,7,3},{2,5,9,3},{6,3,2,5},{4,4,1,6}};
//    public static int[][] map  = {{15,14,13,12},{11,10,9,8},{7,6,5,4},{3,2,1,0}};
//    public static int[][] map  = {{15,14,13,12},{8,9,10,11},{7,6,5,4},{0,1,2,3}};
//    public static Spot[][] mem  = new Spot[4][4];
//    public static void initPath() {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                mem[i][j] = new Spot(map[i][j], new Coordinates(i,j), false);
//            }
//        }
//    }

    public static void readMap() {
        Ski ski = new Ski();
        Scanner in = new Scanner(ski.getClass().getResourceAsStream("map.txt"));
        int rows = in.nextInt();
        int cols = in.nextInt();
        map = new int[rows][cols];
        mem = new Spot[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (in.hasNextInt()) {
                    map[i][j] = in.nextInt();
                    mem[i][j] = new Spot(map[i][j], new Coordinates(i,j), false);
                }
            }
        }
    }
}
