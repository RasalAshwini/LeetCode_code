import java.util.Arrays;
import java.util.List;

public class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort robots and factories by position
        int[] robots = robot.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(robots);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = robots.length;
        int m = factory.length;
        
        // DP array where dp[i][j] is the minimum distance to fix i robots with j factories
        long[][] dp = new long[n + 1][m + 1];
        
        // Initialize DP array with a large value as infinity
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        
        dp[0][0] = 0; // Zero robots and zero factories requires zero distance
        
        // Compute DP
        for (int j = 1; j <= m; j++) { // Iterate over each factory
            dp[0][j] = 0; // If no robots are used, no distance is needed.
            int factoryPos = factory[j - 1][0];
            int limit = factory[j - 1][1];
            
            for (int i = 1; i <= n; i++) { // Iterate over each robot count
                dp[i][j] = dp[i][j - 1]; // Option to not use current factory
                
                long distance = 0;
                for (int k = 1; k <= Math.min(i, limit); k++) { // Try up to 'limit' robots for this factory
                    distance += Math.abs(robots[i - k] - factoryPos);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + distance);
                }
            }
        }
        
        return dp[n][m];
}
}
