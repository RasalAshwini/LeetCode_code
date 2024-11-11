import java.util.*;

class Solution {
    boolean[] isPrime = new boolean[1001];

    
    void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        sieve();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
           
            int prev = (i == 0) ? 0 : nums[i - 1];

            
            for (int p = nums[i] - 1; p > 0; p--) {
                if (isPrime[p] && nums[i] - p > prev) {
                    nums[i] -= p;
                    break;
                }
            }

            
            if (nums[i] <= prev) {
                return false;
            }
        }

        return true;
    }
}
