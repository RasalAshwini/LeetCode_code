class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1; // Length of sequence
        int[] result = new int[size]; // Array to store result
        boolean[] used = new boolean[n + 1]; // Track used numbers
        backtrack(result, used, n, 0);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int n, int index) {
        if (index == result.length) {
            return true; // Successfully placed all numbers
        }
        if (result[index] != 0) {
            return backtrack(result, used, n, index + 1); // Skip filled position
        }

        for (int num = n; num >= 1; num--) { // Start from largest number
            if (used[num]) continue;

            if (num == 1) { // Special case: 1 appears only once
                result[index] = 1;
                used[1] = true;
                if (backtrack(result, used, n, index + 1)) return true;
                result[index] = 0;
                used[1] = false;
            } else {
                int secondPos = index + num; // Calculate second position
                if (secondPos < result.length && result[secondPos] == 0) {
                    result[index] = result[secondPos] = num;
                    used[num] = true;
                    if (backtrack(result, used, n, index + 1)) return true;
                    result[index] = result[secondPos] = 0;
                    used[num] = false;
                }
            }
        }
        return false;
}
}