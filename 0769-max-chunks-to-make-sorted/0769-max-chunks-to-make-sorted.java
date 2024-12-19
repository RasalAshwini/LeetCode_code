class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxSoFar = 0;
        
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            // If maxSoFar matches the index, we can form a chunk
            if (maxSoFar == i) {
                chunks++;
            }
        }
        
        return chunks;
}
}