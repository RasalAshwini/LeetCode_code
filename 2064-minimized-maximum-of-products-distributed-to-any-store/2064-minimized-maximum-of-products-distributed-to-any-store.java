class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;
        for (int q : quantities) {
            high = Math.max(high, q);
        }

        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(mid, n, quantities)) {
                result = mid; // Update the result to the current feasible value
                high = mid - 1; // Try to find a smaller feasible value
            } else {
                low = mid + 1; // Increase the range
            }
        }
        return result;
    }

    private boolean canDistribute(int maxProducts, int n, int[] quantities) {
        int requiredStores = 0;
        for (int q : quantities) {
            // Calculate the number of stores needed for this product type
            requiredStores += (q + maxProducts - 1) / maxProducts; // Equivalent to Math.ceil(q / maxProducts)
            if (requiredStores > n) {
                return false; // Early exit if more stores are needed than available
            }
        }
        return true;
}
}
