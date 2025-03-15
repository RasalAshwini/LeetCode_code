class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int)1e9; // Setting the search range

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canRob(nums, mid, k)) {
                right = mid; // Try for a smaller capability
            } else {
                left = mid + 1; // Increase the capability
            }
        }
        
        return left;
    }
    
    private boolean canRob(int[] nums, int capability, int k) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] <= capability) {
                count++;
                i++; // Skip the next house to ensure non-consecutive robbery
            }
            if (count >= k) return true; // Found a valid way to rob at least k houses
        }
        
        return false; // Not enough houses can be robbed with this capability
    }
}
