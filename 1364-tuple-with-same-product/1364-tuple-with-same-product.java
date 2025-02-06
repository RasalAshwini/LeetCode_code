class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int count = 0;

        // Count the occurrences of each product
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        // Compute the number of valid tuples
        for (int freq : productCount.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1)) / 2 * 8;  // Each pair contributes 8 valid tuples
            }
        }

        return count;
}
}