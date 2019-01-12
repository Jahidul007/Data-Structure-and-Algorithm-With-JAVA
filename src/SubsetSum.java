public class SubsetSum {

    private int[][] dpTable;
    private int[] s;
    private int sum;

    public SubsetSum(int[] s, int sum) {
        this.s = s;
        this.sum = sum;
        this.dpTable = new int[s.length + 2][sum + 1];
    }

    public void solve() {

        // initialize
        for (int i = 0; i < s.length + 1; i++) {
            dpTable[i][0] = 1;
        }
        for (int rowIndex = 1; rowIndex < s.length + 1; rowIndex++) {
            for (int colIndex = 1; colIndex < sum + 1; colIndex++) {
                if (colIndex < s[rowIndex - 1]) {
                    dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex];

                } else {
                    if (dpTable[rowIndex - 1][colIndex] == 1) {
                        dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex];
                    } else {
                        dpTable[rowIndex][colIndex] = dpTable[rowIndex - 1][colIndex - s[rowIndex - 1]];
                    }
                }
            }
        }
        System.out.println("Solution: " + dpTable[s.length][sum]);
    }

    public void showIntegers() {
        int col = sum;
        int row = s.length;

        while (col > 0 || row > 0) {
            if (dpTable[row][col] == dpTable[row - 1][col]) {
                row = row - 1;
            } else {
                System.out.println("We take: " + s[row - 1]);
                col = col - s[row - 1];
                row = row - 1;
            }
        }
    }

    public static void main(String[] args) {

        int[] numbers = {5, 2, 0, 1};
        int sum = 9;
        SubsetSum sum1 = new SubsetSum(numbers, sum);
        sum1.solve();
        sum1.showIntegers();
    }
}
