class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parityChanges = new int[n - 1];
        
        // Compute parityChanges array
        for (int i = 0; i < n - 1; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                parityChanges[i] = 1; // Same parity
            } else {
                parityChanges[i] = 0; // Different parity
            }
        }
        
        // Compute prefix sum of parityChanges
        int[] parityPrefix = new int[n];
        for (int i = 1; i < n; i++) {
            parityPrefix[i] = parityPrefix[i - 1] + parityChanges[i - 1];
        }
        
        // Answer the queries
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            
            if (to == from) {
                // Single element subarray is always special
                answer[i] = true;
            } else {
                // Check if any same-parity pairs exist in range [from, to-1]
                answer[i] = (parityPrefix[to] - parityPrefix[from]) == 0;
            }
        }
        
        return answer;
}
}