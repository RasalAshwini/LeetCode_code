import java.util.*;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) Arrays.stream(ranks).min().getAsInt() * (long) cars * cars;
        long ans = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRepairAll(ranks, cars, mid)) {
                ans = mid;
                right = mid - 1; // Try to minimize time
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canRepairAll(int[] ranks, int cars, long time) {
        long totalCars = 0;
        for (int rank : ranks) {
            totalCars += (long) Math.sqrt(time / rank); 
            if (totalCars >= cars) return true; // No need to check further
        }
        return totalCars >= cars;
}
}