class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0;

        // Min-heap to store elements as [value, index]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Compare indices if values are the same
            }
            return Integer.compare(a[0], b[0]); // Compare values
        });

        // Add all elements to the heap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        // Process the heap
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int index = current[1];

            // Skip if already marked
            if (marked[index]) continue;

            // Add to score and mark the element and its neighbors
            score += value;
            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < n - 1) marked[index + 1] = true;
        }

        return score;
}
}
