package Redmart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Krish on 10/23/17.
 */
public class Ski {
    public static int[][] map  = new int[1000][1000];

    //public static int[][] map  = {{4,9,7,3},{2,5,8,3},{6,3,2,5},{4,4,1,6}};
    public static void readMap() {
        Ski ski = new Ski();
        Scanner in = new Scanner(ski.getClass().getResourceAsStream("map.txt"));
        for (int i = 0; i < 1000; ++i) {
            for (int j = 0; j < 1000; ++j) {
                if (in.hasNextInt()) {
                    map[i][j] = in.nextInt();
                }
            }
        }
    }
}
