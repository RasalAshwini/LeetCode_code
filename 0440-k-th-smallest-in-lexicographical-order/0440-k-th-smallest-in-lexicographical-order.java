class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // Because we already start at the first number

        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1);
            
            if (steps <= k) {
                // Move to the next sibling (e.g., from 1 to 2)
                curr += 1;
                k -= steps;
            } else {
                // Go deeper into the current prefix subtree (e.g., from 1 to 10)
                curr *= 10;
                k -= 1;
            }
        }

        return curr;
    }

    // Helper function to count the number of steps (nodes) between curr and next in lexicographical order
    private int countSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
