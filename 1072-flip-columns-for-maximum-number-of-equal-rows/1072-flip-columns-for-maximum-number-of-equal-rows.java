import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder normal = new StringBuilder();
            StringBuilder flipped = new StringBuilder();

            // Create patterns for the row as-is and its flipped version
            for (int cell : row) {
                normal.append(cell);
                flipped.append(cell ^ 1); // Flipped value: 0 -> 1, 1 -> 0
            }

            String normalPattern = normal.toString();
            String flippedPattern = flipped.toString();

            // Count both normal and flipped patterns
            patternCount.put(normalPattern, patternCount.getOrDefault(normalPattern, 0) + 1);
            patternCount.put(flippedPattern, patternCount.getOrDefault(flippedPattern, 0) + 1);
        }

        // Find the maximum count across all patterns
        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
 }
}