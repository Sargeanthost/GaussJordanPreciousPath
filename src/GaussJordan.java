public class GaussJordan {
    /**
     * @param aug the augmented matrix
     * @return returns the solution to the augmented matrix
     */
    public static void eliminator(float[][] aug) {
        //swap zero entry rows to the bottom
        //swap partial pivot alg
        // divide rows so pivot is 1
        // add/subtract multiples to every other row
        // repeat 2-4 for next leftmost non zero entry until all leading entries are one
        // swap the rows so that leading entry of each row is to the right of the leading entry of the row above it

        int len = aug.length;//num of rows. num of cols is len+1
        //coeff mat will be square so working row is also working col
        for (int currentRow = 0; currentRow < len; currentRow++) {//iterate through coeff part of aug
            int pivotRow = currentRow;

            for (int j = currentRow + 1; j < len; j++) { //next row until last row, check max col val
                if (Math.abs(aug[pivotRow][currentRow]) < Math.abs(aug[j][currentRow])) {
                    pivotRow = j;
                }
            }
            //swap if diff row
            if (pivotRow != currentRow) {
                float[] temp = aug[currentRow];
                aug[currentRow] = aug[pivotRow];
                aug[pivotRow] = temp;
            }

            //same row
            float pivotMaker = aug[currentRow][currentRow];
            for (int k = currentRow; k <= len; k++) {//for every element (including answer vector) in cur row,
                if (pivotMaker != 1.0) {//if = 1 break else aug etc
                    aug[currentRow][k] /= pivotMaker;
                }
            }
            //end same row

            //rref: other row - (this row*scale)
            for (int workingRow = 0; workingRow < len; workingRow++) {//all rows
                if (workingRow == currentRow || aug[workingRow][currentRow] == 0.0) {
                    continue;//if pivot is already knocked out; if row is same as working row
                }
                //can use cr|cr as guaranteed to have no non zero entries to left of [i][i]
                float zeroMaker = aug[workingRow][currentRow] / aug[currentRow][currentRow];
                for (int element = currentRow; element <= len; element++) {
                    aug[workingRow][element] -= aug[currentRow][element] * zeroMaker;
                }
            }
            //dont need to worry about 0 pivot, only solving question 3
            //divide row by what makes pivot 1
            //            float pivotMaker = aug[currentRow][currentRow];
            //            for (int j = currentRow; j <= n + 1; j++) {
            //                aug[currentRow][j] /= pivotMaker;
            //            }
            //            //zero columns above and below pivot through n+1st col
            //            for (int k = 0; k <= n; k++) {//for each row GOOD
            //                float zeroMaker = aug[k][currentRow] / aug[currentRow][currentRow];//the row and col
            //                above current pivot
            //                for (int j = currentRow; j <= n + 1; j++) {//the current and up to n+1 col entries
            //                subtracted by
            //                this zeromaker
            //                    //this row[j] * (that row[j]/this row[pivot]) + that row[j]
            //                    if (k != currentRow && aug[k][j] != 0.0f) {
            //                        //dont want to zero out the current row col value, and dont want to alter row if
            //                        // column below is 0
            //                        aug[k][j] = aug[k][j] - aug[currentRow][j] * zeroMaker;
            //                    }
            //                }
            //            }
        }
    }
}
