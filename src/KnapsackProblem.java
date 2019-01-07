public class KnapsackProblem {

    private int numOfItem;
    private int capacityOfKnapsack;
    private int[][] knapsackTable;
    private int totalBenefit;
    private int[] weights;
    private int[] values;

    public KnapsackProblem(int numOfItem, int capacityOfKnapsack, int[] weights, int[] values) {
        this.numOfItem = numOfItem;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.weights = weights;
        this.values = values;
        this.knapsackTable = new int[numOfItem + 1][capacityOfKnapsack + 1];
    }

    public void solve() {

        // time complexity O(N*W)
        for (int i = 1; i < numOfItem+1; i++) {
            for (int w = 1; w < capacityOfKnapsack+1; w++) {

                int notTakingItem = knapsackTable[i - 1][w];
                int takingItem = 0;

                if (weights[i] <= w) {
                    takingItem = values[i] + knapsackTable[i - 1][w - weights[i]];
                }
                knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
            }
        }
        totalBenefit = knapsackTable[numOfItem][capacityOfKnapsack];
    }
    public void showResults(){

        System.out.println("Total benefit: "+ totalBenefit);

        for (int n= numOfItem, w = capacityOfKnapsack; n>0;n--){
            if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w]){

                System.out.println("We take item : #"+n);
                w = w - weights[n];
            }
        }
    }

    public static void main(String[] args) {
        int numOfItem = 3;
        int capacityOfKnapsack = 5;

        int[] weightsOfItems = new int[numOfItem + 1];
        weightsOfItems[1] = 4;
        weightsOfItems[2] = 2;
        weightsOfItems[3] = 3;

        int[] profitOfItems = new int[numOfItem + 1];
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        KnapsackProblem problem = new KnapsackProblem(numOfItem, capacityOfKnapsack, weightsOfItems, profitOfItems);
        problem.solve();
        problem.showResults();
    }
}
