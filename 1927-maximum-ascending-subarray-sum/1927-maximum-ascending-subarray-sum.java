class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0]; // Initialize maxSum with the first element
        int currentSum = nums[0]; // Initialize currentSum with the first element
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i]; // Add current element to the subarray sum
            } else {
                currentSum = nums[i]; // Reset current sum to the new subarray
            }
            maxSum = Math.max(maxSum, currentSum); // Update maxSum if needed
        }
        
        return maxSum;
}
}