class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Calculate the initial xorSum of all elements in nums
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        
        // The maximum k value within the maximumBit range
        int maxK = (1 << maximumBit) - 1;
        
        // Process each query from end to start
        for (int i = 0; i < n; i++) {
            // Calculate k as the complement within the range of maximumBit
            answer[i] = xorSum ^ maxK;
            
            // Update xorSum by removing the last element in the current array
            xorSum ^= nums[n - 1 - i];
        }
        
        return answer;
}
}
