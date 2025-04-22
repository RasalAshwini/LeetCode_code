class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 10000;
    long[] factorial = new long[MAX + 1];
    long[] invFactorial = new long[MAX + 1];

    public int idealArrays(int n, int maxValue) {
        precomputeFactorials();

        int maxLen = (int)(Math.log(maxValue) / Math.log(2)) + 1;
        long[][] dp = new long[maxLen + 1][maxValue + 1];

        // dp[length][last value]
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }

        for (int len = 2; len <= maxLen; len++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int j = i * 2; j <= maxValue; j += i) {
                    dp[len][j] = (dp[len][j] + dp[len - 1][i]) % MOD;
                }
            }
        }

        long result = 0;
        for (int len = 1; len <= maxLen; len++) {
            long sum = 0;
            for (int i = 1; i <= maxValue; i++) {
                sum = (sum + dp[len][i]) % MOD;
            }
            result = (result + sum * nCr(n - 1, len - 1) % MOD) % MOD;
        }

        return (int) result;
    }

    void precomputeFactorials() {
        factorial[0] = invFactorial[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        invFactorial[MAX] = modInverse(factorial[MAX]);
        for (int i = MAX - 1; i >= 1; i--) {
            invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD;
        }
    }

    long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    long nCr(int n, int r) {
        if (r > n) return 0;
        return factorial[n] * invFactorial[r] % MOD * invFactorial[n - r]%MOD;
}
}