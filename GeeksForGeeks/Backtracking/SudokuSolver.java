import java.util.*;
import java.lang.*;
import java.io.*;

class SudokuSolver {
    int totalTries = 0;

    public static void main (String[] args) {
        SudokuSolver sudoku = new SudokuSolver();
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        while (--testcases >= 0) {
            int[][] arr = new int[9][9];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            //sudoku.printGrid(arr);
            sudoku.sudokuSolver(arr);
            sudoku.print(arr);
            //System.out.println(sudoku.totalTries);
        }
    }

    public boolean sudokuSolver(int[][] grid) {

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    for (int currentVal = 1; currentVal < 10; currentVal++) {
                        if (isValidPlacement(grid, r, c, currentVal)) {
                            grid[r][c] = currentVal;
                            if (sudokuSolver(grid)) {
                                return true;
                            } else {
                                grid[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;

    }

    public boolean isValidPlacement(int[][] grid, int row, int col, int num) {
        totalTries++;
//      printGrid(grid);
        boolean isSafe = true;
        grid[row][col] = num;
        int placedNumber = grid[row][col];

        //Check current row
        for (int i = 0; i < grid[0].length; i++) {
            if (i == col) {
                continue;
            }
            if (grid[row][i] == placedNumber) {
                grid[row][col] = 0;
                return !isSafe;
            }
        }

        //Check current col
        for (int i = 0; i < grid.length; i++) {
            if (i == row) {
                continue;
            }
            if (grid[i][col] == placedNumber) {
                grid[row][col] = 0;
                return !isSafe;
            }
        }

        //Check local grid
        int startLocalGridRow = row - (row % 3);
        int startLocalGridCol = col - (col % 3);

        for (int i = startLocalGridRow; i < startLocalGridRow + 3; i++) {
            for (int j = startLocalGridCol; j < startLocalGridCol + 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (grid[i][j] == placedNumber) {
                    grid[row][col] = 0;
                    return !isSafe;
                }
            }
        }
        return isSafe;
    }


    public void printGrid(int[][] grid) {
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        System.out.println();
    }
}