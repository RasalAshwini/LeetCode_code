import java.util.*;

class Solution {
    private int[] segTree; // Segment Tree

    private void buildSegmentTree(int[] heights, int start, int end, int stIdx) {
        if (start == end) {
            segTree[stIdx] = start;
            return;
        }

        int mid = start + (end - start) / 2;
        buildSegmentTree(heights, start, mid, 2 * stIdx);
        buildSegmentTree(heights, mid + 1, end, 2 * stIdx + 1);

        segTree[stIdx] = heights[segTree[2 * stIdx]] >= heights[segTree[2 * stIdx + 1]]
                ? segTree[2 * stIdx] : segTree[2 * stIdx + 1];
    }

    private int rangeMaxQuery(int[] heights, int qs, int qe, int start, int end, int stIdx) {
        if (start >= qs && end <= qe) // Total Overlap
            return segTree[stIdx];
        if (start > qe || end < qs) // No Overlap
            return Integer.MIN_VALUE;

        // Partial Overlap
        int mid = start + (end - start) / 2;
        int leftMax = rangeMaxQuery(heights, qs, qe, start, mid, 2 * stIdx);
        int rightMax = rangeMaxQuery(heights, qs, qe, mid + 1, end, 2 * stIdx + 1);

        if (leftMax == Integer.MIN_VALUE) return rightMax;
        if (rightMax == Integer.MIN_VALUE) return leftMax;

        return heights[leftMax] >= heights[rightMax] ? leftMax : rightMax;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        segTree = new int[4 * n + 1];
        int stIdx = 1; // Segment Tree Index: Root at index 1

        buildSegmentTree(heights, 0, n - 1, stIdx);

        int[] res = new int[queries.length];
        int queryIdx = 0;
        for (int[] query : queries) {
            int alice = Math.min(query[0], query[1]);
            int bob = Math.max(query[0], query[1]);

            if (alice == bob || heights[bob] > heights[alice]) {
                res[queryIdx++] = bob;
                continue;
            }

            // Binary Search + RMQ (Range Max Query)
            int low = bob, high = n - 1, ans = Integer.MAX_VALUE;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int rmq = rangeMaxQuery(heights, low, mid, 0, n - 1, stIdx);

                if (heights[rmq] > heights[alice]) {
                    high = mid - 1;
                    ans = Math.min(ans, rmq);
                } else {
                    low = mid + 1;
                }
            }
            res[queryIdx++] = ans == Integer.MAX_VALUE ? -1 : ans;
        }
        return res;
    }
}
