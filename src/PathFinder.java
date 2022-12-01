import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PathFinder {
    /**
     * Finds the most precious path (greatest sum), with the last index the vault number. Moves allowed are up, diag
     * left, and diag right.
     *
     * @param matrix a matrix with gemstone values as elements
     * @return returns a List of indices with the optimal sums in backtracking order. Last entry will the vault number
     * with the Arkenstone in it
     */
    public static List<Integer> mostPreciousPath(int[][] matrix) {
        List<Integer> path = new ArrayList<>();

        //Modify array
        for (int curRow = matrix.length - 2; curRow >= 0; curRow--) {
            int max = 0;
            //for each col in row, check its constituents from previous row.
            for (int col = 0; col < matrix[0].length; col++) {
                int[] posMaxes = new int[3];
                for (int offset = 0; offset < 3; offset++) {
                    int index = col + (offset -1);
                    if (index >= 0 && index < matrix[0].length) {
                        posMaxes[offset] = matrix[curRow+1][index];
                    }
                }
                matrix[curRow][col] += IntStream.of(posMaxes).max().orElseThrow();
            }
        }

        //Backtrack

        return path;
    }
}
