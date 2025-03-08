class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOperations = Integer.MAX_VALUE;
        int whiteCount = 0;

        // Count white blocks in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        minOperations = whiteCount;

        // Slide the window across the string
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--; // Remove the leftmost block from the window
            }
            if (blocks.charAt(i) == 'W') {
                whiteCount++; // Add the new rightmost block to the window
            }
            minOperations = Math.min(minOperations, whiteCount);
        }

        return minOperations;
}
}