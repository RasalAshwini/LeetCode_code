import java.util.*;

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Build the adjacency list for the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        
        // Result to store the number of valid components
        int[] result = new int[1];
        
        // Perform DFS to compute valid splits
        dfs(0, -1, tree, values, k, result);
        
        return result[0];
    }

    private int dfs(int node, int parent, List<List<Integer>> tree, int[] values, int k, int[] result) {
        // Start with the value of the current node
        int subtreeSum = values[node];
        
        // Traverse all neighbors
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                // Recursively calculate the sum for child nodes
                subtreeSum += dfs(neighbor, node, tree, values, k, result);
            }
        }
        
        // Check if the subtree sum is divisible by k
        if (subtreeSum % k == 0) {
            result[0]++; // Increment the count of valid components
            return 0;   // Returning 0 means this subtree can be considered a valid component
        }
        
        // Return the sum modulo k for further computation
        return subtreeSum % k;
}
}
