class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[V];
        int count = 0;

        // 1. Create reverse graph and calculate indegree
        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                adj.get(v).add(u);
                indegree[u]++;
            }
        }

        // 2. Fill queue with nodes having indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        // 3. Simple BFS
        boolean[] safe = new boolean[V];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            safe[u] = true;

            for (int v : adj.get(u)) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}