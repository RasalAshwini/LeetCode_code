class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int zeroCount = 0;
        long count = 0;

        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                count += zeroCount;
            }
        }
        return count;
    }
}
