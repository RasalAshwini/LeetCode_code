class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Create adjacency list and indegree array
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        // Initialize queue with nodes having indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Map from node to set of prerequisite nodes
        Map<Integer, Set<Integer>> prereqMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                // Add current node and its prerequisites to the neighbor's prerequisites
                prereqMap.computeIfAbsent(neighbor, k -> new HashSet<>()).add(node);
                prereqMap.get(neighbor).addAll(prereqMap.getOrDefault(node, new HashSet<>()));

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Process each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int src = query[0];
            int dest = query[1];
            result.add(prereqMap.getOrDefault(dest, new HashSet<>()).contains(src));
        }

        return result;
    }
}