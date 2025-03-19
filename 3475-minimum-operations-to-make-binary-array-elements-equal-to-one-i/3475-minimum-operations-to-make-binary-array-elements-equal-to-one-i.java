public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int flip = 0;  // Tracks whether we are in a flipped state
        int operations = 0;

        for (int i = 0; i < n; i++) {
            // If we're past index 2, remove the effect of operations done at index i - 3
            if (i >= 3 && nums[i - 3] == 2) {
                flip ^= 1;  // Toggle the flip status as the previous flip ends its effect here
            }

            // If the current element is 0 and flip is even (or 1 and flip is odd)
            if ((nums[i] ^ flip) == 0) {
                // If we can't flip the next two elements, return -1
                if (i > n - 3) return -1;

                // Mark this position as a flip-start point by setting it to '2'
                nums[i] = 2; 
                
                // Toggle the flip status for the next three positions
                flip ^= 1; 
                
                // Count this operation
                operations++;
            }
        }
        return operations;
    }


}
