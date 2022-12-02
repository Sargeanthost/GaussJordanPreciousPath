import java.util.stream.IntStream;

public class PathFinder {
    /**
     * Finds the most precious path (maximum path sum), with the last index set as the vault number. Moves allowed are
     * up, diag left, and diag right.
     *
     * @param matrix a matrix with gemstone values as elements
     * @return returns an array of indices with the optimal sums in backtracking order. Last entry is max sum
     */
    public static int[] mostPreciousPath(int[][] matrix) {
        int[] path = new int[matrix.length + 1];

        //Modify array, starting at second row
        for (int curRow = matrix.length - 2; curRow >= 0; curRow--) {
            for (int col = 0; col < matrix[0].length; col++) {
                int[] posMaxes = new int[3];
                for (int offset = 0; offset < 3; offset++) {
                    int index = col + (offset - 1);
                    if (index >= 0 && index < matrix[0].length) {
                        posMaxes[offset] = matrix[curRow + 1][index];
                    }
                }
                matrix[curRow][col] += IntStream.of(posMaxes).max().orElseThrow();
            }
        }

        //Greedy backtrack

        //Find max value for row N
        int maxSumIndex = getMaxIndex(matrix[0]);

        path[0] = maxSumIndex;
        path[path.length - 1] = matrix[0][maxSumIndex];
        //start backtrack
        for (int curRow = 0; curRow < matrix.length - 1; curRow++) {
            //            int prevMaxIndex = maxSumIndex;
            int[] posMaxes = new int[3];
            for (int offset = 0; offset < 3; offset++) {
                int index = maxSumIndex + (offset - 1);
                if (index >= 0 && index < matrix[0].length) {
                    posMaxes[offset] = matrix[curRow + 1][index];
                }
            }
            maxSumIndex += getMaxIndex(posMaxes) - 1;
            path[curRow + 1] = maxSumIndex;
        }
        return path;
    }

    private static int getMaxIndex(int[] arr) {
        int maxSumIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            maxSumIndex = arr[i] > arr[maxSumIndex] ? i : maxSumIndex;
        }
        return maxSumIndex;
    }
}
