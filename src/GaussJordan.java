public class GaussJordan {
    /**
     * Gauss-Jordan elimination. Some liberties have been taken with this code and I don't expect it to work for mxn
     * coeff matrices (not tested). Works on assumption that means "modify the algorithm in the book", modification
     * can be done to the input, as the user now has to append arr a and b. What's also not tested are dependent
     * systems.
     * A flag system could be introduced and sent to a helper function if this is the case, as well as a while loop to
     * iterate over potential pivots in the row, and if none are found send the 0 row vector to the bottom of the
     * matrix.
     *
     * @param aug the augmented matrix
     */
    public static void eliminator(float[][] aug) {
        //swap partial pivot alg
        // divide rows so pivot is 1
        // add/subtract multiples to every other row
        // repeat 2-4 for next leftmost non-zero entry until all leading entries are one
        // swap the rows so that leading entry of each row is to the right of the leading entry of the row above it

        int len = aug.length;//num of rows. num of cols is len+1
        for (int currentRow = 0; currentRow < len; currentRow++) {//iterate through coeff part of aug
            int pivotRow = currentRow;
            for (int j = currentRow + 1; j < len; j++) { //next row until last row, check max col val
                if (Math.abs(aug[pivotRow][currentRow]) < Math.abs(aug[j][currentRow])) {
                    pivotRow = j;
                }
            }
            if (pivotRow != currentRow) {
                float[] temp = aug[currentRow];
                aug[currentRow] = aug[pivotRow];
                aug[pivotRow] = temp;
            }

            float pivotMaker = aug[currentRow][currentRow];
            for (int k = currentRow; k <= len; k++) {//for every element (including answer vector) in cur row,
                if (pivotMaker == 1.0) {//if = 1 break else aug etc
                    break;
                } else {
                    aug[currentRow][k] /= pivotMaker;
                }
            }

            for (int workingRow = 0; workingRow < len; workingRow++) {//all rows
                if (workingRow == currentRow || aug[workingRow][currentRow] == 0.0) {
                    continue;
                }
                //can use cr|cr as guaranteed to have no non-zero entries to left of i|i
                float zeroScaler = aug[workingRow][currentRow];//  /aug[currentRow][currentRow]. works cause pivot 1
                for (int element = currentRow; element <= len; element++) {
                    aug[workingRow][element] -= aug[currentRow][element] * zeroScaler;
                }
            }
        }
    }
}
