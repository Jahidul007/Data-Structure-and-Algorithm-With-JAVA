public class ColoringProblem {
    private int numOfVertexes;
    private int numOfColors;
    private int[] colors;
    private int[][] adjacencyMatrix;

    public ColoringProblem(int[][] adjacencyMatrix, int numOfColors) {
        this.numOfColors = numOfColors;
        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfVertexes = adjacencyMatrix.length;
        this.colors = new int[numOfVertexes];
    }

    public void solve() {

        if (solveProblem(0)) {
            showResults();
        } else {
            System.out.println("There is no solution....");
        }

    }

    private boolean solveProblem(int nodeIndex) {

        if (nodeIndex == numOfVertexes) {
            return true;
        }
        for (int colorIndex = 1; colorIndex < numOfColors; colorIndex++) {

            if (isValid(nodeIndex, colorIndex)) {
                colors[nodeIndex] = colorIndex;
                if (solveProblem(nodeIndex + 1)) {
                    return true;
                }
                // BackTrack !!!!
            }
        }
        return false;
    }

    private boolean isValid(int nodeIndex, int colorIndex) {

        for (int i = 0; i < numOfVertexes; i++){
            if (adjacencyMatrix[nodeIndex][i] == 1 && colorIndex == colors[i]){
                return false;
            }
        }

        return true;
    }

    private void showResults() {
        for (int i = 0; i < numOfVertexes; i++) {
            System.out.println("Node " + (i + 1) + " has a color index " + colors[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1,0,0},
                {1,0,1,0,1,0},
                {1,1,1,1,0,1},
                {1,0,1,0,0,1},
                {0,1,0,0,0,1},
                {0,1,1,1,1,1}
        };
        ColoringProblem problem = new ColoringProblem(matrix, 4);

        problem.solve();
    }
}
