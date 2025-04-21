class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, current = 0;

        for (int diff : differences) {
            current += diff;
            min = Math.min(min, current);
            max = Math.max(max, current);
        }

        long startMin = lower - min;
        long startMax = upper - max;

        if (startMax < startMin) return 0;

        return (int)(startMax - startMin+1);
}
}