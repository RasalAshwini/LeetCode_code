class Solution {
    public int largestCombination(int[] candidates) {
        // There are 24 relevant bits for numbers up to 10^7
        int[] bitCount = new int[24];
        int maxCombination = 0;

        // Count the number of times each bit is set to 1
        for (int num : candidates) {
            for (int i = 0; i < 24; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }

        // Find the maximum count of any bit position
        for (int count : bitCount) {
            maxCombination = Math.max(maxCombination, count);
        }

        return maxCombination;
    }
}
