public class SudokuProblem {
    public static final int BOARD_SIZE = 9;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int BOX_SIZE = 3;

    private int[][] sudokuTable;

    public SudokuProblem(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public void solveProblem() {
        if (solve(0, 0)) {
            showResults();
        } else {
            System.out.println("There is no solution.......");
        }
    }

    private boolean solve(int rowIndex, int columIndex) {
        if (rowIndex == BOARD_SIZE && ++columIndex == BOARD_SIZE){
            return true;
        }
        if (rowIndex == BOARD_SIZE) {
             rowIndex = 0;
        }
        if (sudokuTable[rowIndex][columIndex] != 0) {
            return solve(rowIndex + 1, columIndex);
        }

        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {

            if (valid(rowIndex, columIndex, number)) {

                sudokuTable[rowIndex][columIndex] = number;

                if (solve(rowIndex + 1, columIndex)) {
                    return true;
                }
                // BackTrack
                sudokuTable[rowIndex][columIndex] = 0;
            }
        }
        return false;
    }

    private boolean valid(int rowIndex, int columIndex, int number) {

        // if given number is already in the row; the number can't be the part of solution
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (sudokuTable[i][rowIndex] == number) {
                return false;
            }
        }
        // if given number is already in the column; the number can't be the part of solution
        for (int k = 0; k < BOARD_SIZE; k++) {
            if (sudokuTable[columIndex][k] == number) {
                return false;
            }
        }
        // if given number is already in the box; the number can't be the part of solution
        int boxRowOffSet = (columIndex / 3) * BOX_SIZE;
        int boxColumnOffSet = (rowIndex / 3) * BOX_SIZE;

        for (int i = 0; i < BOX_SIZE; ++i)
            for (int j = 0; j < BOX_SIZE; ++j)
                if (number == sudokuTable[boxRowOffSet + i][boxColumnOffSet + j])
                    return false;
        return true;
    }


    private void showResults() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i % 3 == 0) System.out.println(" ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j % 3 == 0) System.out.print(" ");
                System.out.print(sudokuTable[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int[][] sudokuTab = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int[][] sudoku = {
                {8,6,0,0,2,0,0,0,0},
                {0,0,0,7,0,0,0,5,9},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,6,0,8,0,0},
                {0,4,0,0,0,0,0,0,0},
                {0,0,5,3,0,0,0,0,7},
                {0,0,0,0,0,0,0,0,0},
                {0,2,0,0,0,0,6,0,0},
                {0,0,7,5,0,9,0,0,0}
        };
        SudokuProblem problem = new SudokuProblem(sudokuTab);
        problem.solveProblem();
    }
}
