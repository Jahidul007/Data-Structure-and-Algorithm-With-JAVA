public class HamiltonianCycle {

    private int numOfVertices;
    private int[] hamiltonPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonPath = new int[adjacencyMatrix.length];
        this.numOfVertices = adjacencyMatrix.length;

        this.hamiltonPath[0] = 0;
    }

    public void solve() {

        if (findFeasibleSolution(1)) {
            showHamiltonianPath();
        } else {
            System.out.println("There is no solution...");
        }
    }

    private boolean findFeasibleSolution(int position) {

        if (position == numOfVertices) {
            if (adjacencyMatrix[hamiltonPath[position - 1]][hamiltonPath[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }
        for (int vertexIndex = 1; vertexIndex < numOfVertices; vertexIndex++) {
            if (isFeasible(vertexIndex, position)) {

                hamiltonPath[position] = vertexIndex;
                if (findFeasibleSolution(position + 1)) {
                    return true;
                }
                // BackTrack !!!
            }
        }
        return false;
    }

    private boolean isFeasible(int vertexIndex, int position) {

        // first criterion: whether two nodes are connected
        if (adjacencyMatrix[hamiltonPath[position - 1]][vertexIndex] == 0) {
            return false;
        }
        // second criterion: whether we have visited or not

        for (int i = 0; i < position; i++) {
            if (hamiltonPath[i] == vertexIndex) {
                return false;
            }
        }
        return true;
    }

    private void showHamiltonianPath() {

        System.out.print("Hamiltonian cycle: ");
        for (int i = 0; i < hamiltonPath.length; i++) {
            System.out.print(hamiltonPath[i] + " ");
        }
        System.out.print(hamiltonPath[0]);
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1}
        };
        HamiltonianCycle cycle = new HamiltonianCycle(matrix);
        cycle.solve();

    }
}
