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
    public void solve(){

        if (solveProblem(0)){
            showResults();
        } else{
            System.out.println("There is no solution....");
        }

    }

    private boolean solveProblem(int i) {

        return false;
    }

    private void showResults() {
        for (int i = 0; i<numOfVertexes; i++){
            System.out.println("Node" + (i+1)+ " has a color index " + colors[i]);
        }
    }
}
