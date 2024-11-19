class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currentSum = 0;
        
        // HashMap to keep track of the count of each element in the current window
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            // Add the current element to the sum and increase its count
            currentSum += nums[i];
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0) + 1);
            
            // If the window exceeds size k, slide the window
            if (i >= k) {
                int elementToRemove = nums[i - k];
                currentSum -= elementToRemove;
                
                // Update the count in the map and remove if it's zero
                elementCount.put(elementToRemove, elementCount.get(elementToRemove) - 1);
                if (elementCount.get(elementToRemove) == 0) {
                    elementCount.remove(elementToRemove);
                }
            }
            
            // If we have exactly k distinct elements, check the sum
            if (i >= k - 1 && elementCount.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
}
}
