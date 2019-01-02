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
        if (rowIndex == BOARD_SIZE && ++columIndex == BOARD_SIZE)
            return true;
        if (rowIndex == BOARD_SIZE) {
            rowIndex = 0;
        }
        if (sudokuTable[rowIndex][columIndex] != 0) {
            solve(rowIndex + 1, columIndex + 1);
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

        // if given number is already in the row can't be the part of solution
        for (int i = 0; i <= BOARD_SIZE; i++) {
            if (sudokuTable[i][rowIndex] == number) {
                return false;
            }
        }
        // if given number is already in the column can't be the part of solution
        for (int k = 0; k <= BOARD_SIZE; k++) {
            if (sudokuTable[columIndex][k] == number) {
                return false;
            }

        }
        int boxRowOffSet = (columIndex / 3) * BOX_SIZE;
        int boxColumnOffSet = (rowIndex / 3) * BOX_SIZE;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {

                if (number == sudokuTable[boxRowOffSet + i][boxColumnOffSet + j])
                    return false;
            }
        }

        return true;
    }


    private void showResults() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i % 3 == 0) System.out.println(" ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (j % 3 == 0) System.out.println(" ");
                System.out.print(sudokuTable[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
