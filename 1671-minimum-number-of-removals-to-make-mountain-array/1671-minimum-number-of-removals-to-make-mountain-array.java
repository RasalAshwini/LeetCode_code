class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n]; // LIS from left
        int[] lds = new int[n]; // LDS from right
        
        // Compute LIS for each index from the left
        for (int i = 0; i < n; i++) {
            lis[i] = 1; // Every element is an increasing subsequence of length 1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        
        // Compute LDS for each index from the right
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1; // Every element is a decreasing subsequence of length 1
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        
        // Calculate the maximum mountain length
        int maxMountainLen = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // Valid peak condition
                maxMountainLen = Math.max(maxMountainLen, lis[i] + lds[i] - 1);
            }
        }
        
        // Minimum removals to make the array a mountain array
        return n - maxMountainLen;
    }
}
