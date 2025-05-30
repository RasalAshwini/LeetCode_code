class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        // Function to get distances from a given node
        int[] distFromNode1 = getDistances(edges, node1);
        int[] distFromNode2 = getDistances(edges, node2);

        int result = -1;
        int minMaxDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (distFromNode1[i] != -1 && distFromNode2[i] != -1) {
                int maxDist = Math.max(distFromNode1[i], distFromNode2[i]);
                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }

    // Helper function to get distance from start node to all reachable nodes
    private int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int current = start;
        int distance = 0;

        while (current != -1 && dist[current] == -1) {
            dist[current] = distance++;
            current = edges[current];
        }

        return dist;
}
}