import java.util.*;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        for (int c : candies) totalCandies += c; // Avoid integer overflow
        
        if (totalCandies < k) return 0; // If total candies are less than k, return 0

        int low = 1, high = Arrays.stream(candies).max().getAsInt();
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid; // Try larger candy size
                low = mid + 1;
            } else {
                high = mid - 1; // Try smaller candy size
            }
        }
        return result;
    }

    private boolean canDistribute(int[] candies, long k, int mid) {
        long count = 0; // Total number of children that can receive candies
        for (int c : candies) {
            count += c / mid;
            if (count >= k) return true; // No need to check further
        }
        return count >=k;
}
}