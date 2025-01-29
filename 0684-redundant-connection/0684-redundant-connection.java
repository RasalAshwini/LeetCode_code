class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1]; // Parent array
        int[] rank = new int[n + 1];   // Rank array to optimize union operation
        
        // Initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // Initially, each node is its own parent
            rank[i] = 1;   // Initial rank is 1
        }
        
        // Process each edge
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], parent, rank)) {
                return edge; // If union returns false, this edge is redundant
            }
        }
        
        return new int[0]; // Should not reach here
    }

    // Find function with path compression
    private int find(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent); // Path compression
        }
        return parent[node];
    }

    // Union function with union by rank
    private boolean union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        
        if (rootU == rootV) return false; // Cycle detected
        
        // Union by rank
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        return true;
}
}