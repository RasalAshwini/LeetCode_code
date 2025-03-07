class Solution {
    public int[] closestPrimes(int left, int right) {
        int LIMIT = 1000000;
        boolean[] isPrime = new boolean[LIMIT + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primesInRange = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primesInRange.add(i);
            }
        }

        if (primesInRange.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 1; i < primesInRange.size(); i++) {
            int num1 = primesInRange.get(i - 1);
            int num2 = primesInRange.get(i);
            int diff = num2 - num1;

            if (diff < minDiff) {
                minDiff = diff;
                result[0] = num1;
                result[1] = num2;
            }
        }

        return result;
}}