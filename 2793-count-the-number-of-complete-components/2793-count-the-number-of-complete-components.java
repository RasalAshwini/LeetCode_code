import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeCount = 0;

        // Step 2: Find connected components using DFS
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);

                // Step 3: Check if the component is complete
                if (isComplete(component, adj)) {
                    completeCount++;
                }
            }
        }
        return completeCount;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }

    private boolean isComplete(List<Integer> component, List<List<Integer>> adj) {
        int size = component.size();
        for (int node : component) {
            if (adj.get(node).size() != size - 1) {
                return false; // If a node does not have exactly size-1 edges, it's not a complete component
            }
        }
        return true;
}
}
