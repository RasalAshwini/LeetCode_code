class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, right = 0;
        int bitMask = 0;
        int maxLen = 0;

        while (right < nums.length) {
            // Check if adding nums[right] causes conflict
            while ((bitMask & nums[right]) != 0) {
                // Remove nums[left] from bitMask
                bitMask ^= nums[left];
                left++;
            }
            
            // Add nums[right] to the current bitMask
            bitMask |= nums[right];
            
            // Update the maximum length of the valid subarray
            maxLen = Math.max(maxLen, right - left + 1);
            
            // Move right pointer to the next element
            right++;
        }

        return maxLen;
    }
}
