class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Calculate prefix sums for the top and bottom rows
        long[] topPrefix = new long[n + 1];
        long[] bottomPrefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            topPrefix[i + 1] = topPrefix[i] + grid[0][i];
            bottomPrefix[i + 1] = bottomPrefix[i] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        // Iterate through all possible switch points
        for (int c = 0; c < n; c++) {
            long topRemaining = topPrefix[n] - topPrefix[c + 1]; // Top row points after column c
            long bottomRemaining = bottomPrefix[c];            // Bottom row points before column c
            long secondRobotPoints = Math.max(topRemaining, bottomRemaining);
            result = Math.min(result, secondRobotPoints);
        }

        return result;
    }
}