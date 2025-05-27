class Solution {
    public int differenceOfSums(int n, int m) {
        // Sum of all numbers from 1 to n: n * (n + 1) / 2
        int totalSum = n * (n + 1) / 2;

        // Count of numbers divisible by m in [1, n]
        int countDivisible = n / m;

        // Sum of numbers divisible by m:
        // m + 2m + 3m + ... + countDivisible * m
        // = m * (1 + 2 + ... + countDivisible)
        // = m * countDivisible * (countDivisible + 1) / 2
        int sumDivisible = m * countDivisible * (countDivisible + 1) / 2;

        // num1 = totalSum - sumDivisible (sum of numbers NOT divisible by m)
        int num1 = totalSum - sumDivisible;
        int num2 = sumDivisible;

        return num1 - num2;  // difference
}
}