import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> adj;

    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); 
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        visited[0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();
                if (node == n - 1) {
                    return level;
                }

                for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        adj = new HashMap<>();
        for (int i = 0; i <= n - 2; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
            adj.get(i).add(i + 1);
        }

        int q = queries.length;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v); 

            int d = bfs(n); 
            result[i] = d;
        }

        return result;
    }
}
