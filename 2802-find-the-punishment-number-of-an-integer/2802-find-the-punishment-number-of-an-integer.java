class Solution {
    public int punishmentNumber(int n) {
        int totalSum = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canPartition(String.valueOf(square), i, 0, 0)) {
                totalSum += square;
            }
        }

        return totalSum;
    }

    private boolean canPartition(String s, int target, int index, int currentSum) {
        if (index == s.length()) {
            return currentSum == target;
        }

        int num = 0;
        for (int i = index; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0'); // Forming the number
            if (canPartition(s, target, i + 1, currentSum + num)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.punishmentNumber(10)); // Output: 182
        System.out.println(sol.punishmentNumber(37)); // Output: 1478
}
}