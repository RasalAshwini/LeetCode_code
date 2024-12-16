class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Find the index of the first occurrence of the minimum value
            int minIndex = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Multiply the selected minimum value by the multiplier
            nums[minIndex] *= multiplier;
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {2, 1, 3, 5, 6};
        int k1 = 5;
        int multiplier1 = 2;
        int[] result1 = solution.getFinalState(nums1, k1, multiplier1);
        System.out.println(java.util.Arrays.toString(result1)); // Expected: [8, 4, 6, 5, 6]

        // Test case 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        int multiplier2 = 4;
        int[] result2 = solution.getFinalState(nums2, k2, multiplier2);
        System.out.println(java.util.Arrays.toString(result2)); // Expected: [16, 8]
}
}
