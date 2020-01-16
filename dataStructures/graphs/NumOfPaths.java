package graphs;

/**
 * Count the total number of ways or paths that exist between two vertices in a directed graph.
 * These paths doesn’t contain a cycle, the simple enough reason is that a cylce contain
 * infinite number of paths and hence they create problem.
 */
public class NumOfPaths {
    static boolean[][] graph;

    public static int getNumOfPaths(boolean[] visited, int start, int destination, int count) {
        visited[start] = true;
        if (start == destination) {
            count++;
        } else {
            for (int i = 0; i < graph[start].length; i++) {
                if (graph[start][i] && !visited[i])
                    count = getNumOfPaths(visited, i, destination, count);
            }
        }
        visited[start] = false;
        return count;
    }
}
