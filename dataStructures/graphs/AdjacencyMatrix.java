package graphs;

public class AdjacencyMatrix {
    private boolean adjMatrix[][];
    private int vertexCount;

    public AdjacencyMatrix(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjMatrix = new boolean[vertexCount][vertexCount];
    }

    public AdjacencyMatrix(int vertexCount, boolean[][] adjMatrix) {
        this.vertexCount = vertexCount;
        this.adjMatrix = adjMatrix;
    }

    public void addEdge(int i, int j) {
        validateIndexes(i, j);
        this.adjMatrix[i][j] = true;
        this.adjMatrix[j][i] = true;
    }

    public boolean isEdge(int i, int j) {
        validateIndexes(i, j);
        return adjMatrix[i][j];
    }

    private void validateIndexes(int i, int j) {
        if (i < 0 || i > this.vertexCount
                || j < 0 || j > this.vertexCount)
            throw new IllegalArgumentException();
    }
}
