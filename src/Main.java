import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //The repaired ForwardAlgorithm algorithm doesn't work because it cant do row swaps. This is a problem because
        // when there is a 0 where a pivot should be, A[i][i], a scalar will fail to be formed that will eliminate
        // the entry below it in the i+1 row. This is because nothing can be multiplied by 0 to create a non-zero
        // number.

        //The BetterForwardAlgorithm doesn't work because the matrix is linearly dependant. This causes there to be a
        // "correct" swap at the beginning that still results in a 0 in the A[i][i] position. Thus, when coming up
        // with a scalar to reduce the row below, you'll get 0/0 (also zero due to linear dependence), or nan in java.
        // The remedy for this is to check whether the current pivot is 0. If it is zero, move to the next column,
        // until the n-2nd column (solutions column is skipped). Since the correct swaps have already taken place, if
        // there are no pivots left in the ith row, then the matrix is guaranteed in upper triangular form as the
        // only items under the potential pivot are 0.

        gaussJordanElimination();
//        biggestSumTraversal();
    }

    private static void biggestSumTraversal() {
        // vault 1 | vault 2...
        //Row 8
        //Row 7...

        // Start on row 1
        //Advance to next row by:
        //  Straight up,Diag left, Diag right (given he doesnt fall off[bounds check])
        //Collecting a gem on row 8 that gives highest value is the column index for the vault
        final int [][] lonely = {
            {96,33,44,98,75,68,99,84},
            {10,41,1,86,46,24,53,93},
            {83,97,94,27,65,51,30,7},
            {56,70,47,64,22,88,67,12},
            {91,11,77,48,13,71,92,15},
            {32,59,17,25,31,4,16,63},
            {79,5,14,23,78,37,40,74},
            {35,89,52,66,82,20,95,21}};
        List<Integer> preciousPath = PathFinder.mostPreciousPath(lonely);
        System.out.println("After modification: ");
        printDeepArray(lonely);
        //starting square: first element
        //path: print list - 1
        //total number of gems: list.size() -1
        //vault number: list.get size()

    }

    private static void gaussJordanElimination(){
        float[][] num3 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 364}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 16}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 36},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 64}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 100},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 79}, {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 61},
            {0, 0, 0, 0, 0, 4, -3, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 3, -2, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, -1, 0, 0, 0}, {1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1, -42}};
        //triangle numbers
        float[][] test1 = {{1,0,2,3},{0,1,0,1},{0,1,2,0}};
        //4,1,1/2

        System.out.println("Answer to number 3: ");
        GaussJordan.eliminator(num3);
        printDeepArray(num3);
        System.out.println("Test from online: ");
        GaussJordan.eliminator(test1);
        printDeepArray(test1);
    }

    private static void printDeepArray(float[][] arr){
        for (float[] row : arr){
            for(float elem : row){
                //integer solution point
                System.out.print(Math.round(elem * 100.0) / 100.0 + " ");
            }
            System.out.println();
        }
    }
    private static void printDeepArray(int[][] arr){
        for (int[] row : arr){
            System.out.println(Arrays.toString(row));
        }
    }
}