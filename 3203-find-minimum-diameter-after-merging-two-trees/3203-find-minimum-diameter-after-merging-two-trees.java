import java.util.*;

public class Solution {

    // Function to build the adjacency list for a tree
    public Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Build adjacency lists for both trees
        Map<Integer, List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdjList(edges2);

        // Calculate the diameters of both trees
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        // Calculate the longest path that spans across both trees
        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        // Return the maximum of the three possibilities
        return Math.max(Math.max(d1, d2), combined);
    }

    // Function to find the diameter of a tree using two BFS calls
    public int findDiameter(Map<Integer, List<Integer>> adjList) {
        // First BFS to find the farthest node from any arbitrary node (e.g., 0)
        int[] farthestNode = BFS(adjList, 0);

        // Second BFS from the farthest node to determine the diameter
        int[] diameterInfo = BFS(adjList, farthestNode[0]);
        return diameterInfo[1];
    }

    // BFS helper function to find the farthest node and its distance from the source
    public int[] BFS(Map<Integer, List<Integer>> adjList, int sourceNode) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(new int[]{sourceNode, 0}); // {node, distance}
        visited.add(sourceNode);

        int farthestNode = sourceNode, maxDistance = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], distance = current[1];

            if (distance > maxDistance) {
                maxDistance = distance;
                farthestNode = node;
            }

            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        return new int[]{farthestNode, maxDistance};
}
}
