import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //The repaired ForwardAlgorithm algorithm doesnt work because it cant do row swaps. This is a problem because
        // when there is a 0 where a pivot should be, A[i][i], a scalar will fail to be formed that will eliminate
        // the entry below it in the i+1 row. This is because nothing can be multiplied by 0 to create a non zero
        // number.

        //The BetterForwardAlgorithm doesn't work because the matrix is linearly dependant. This causes there to be a
        // "correct" swap at the beginning that still results in a 0 in the A[i][i] position. Thus, when coming up
        // with a scalar to reduce the row below, you'll get 0/0 (also zero due to linear dependence), or nan in java.
        // The remedy for this is to check whether the current pivot is 0. If it is zero, move to the next column,
        // until the n-2nd column (solutions column is skipped). Since the correct swaps have already taken place, if
        // there are no pivots left in the ith row, then the matrix is guaranteed in upper triangular form as the
        // only items under the potential pivot are 0.
        float[][] num3 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 364}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 16}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 36},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 64}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 100},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 79}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 61},
            {0, 0, 0, 0, 0, 4, -3, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 3, -2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, -1, 0, 0, 0}, {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, -42}};
        //triangle numbers
        float[][] test1 = {{1,0,2,3},{0,1,0,1},{0,1,2,0}};
        //4,1,1/2

        float[][] current = test1;
        GaussJordan.eliminator(current);
        for (float[] row : current) {
            System.out.println(Arrays.toString(row));
        }
    }
}