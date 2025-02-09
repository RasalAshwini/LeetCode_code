import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        long totalPairs = (long) nums.length * (nums.length - 1) / 2; // Total pairs (nC2)
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = i - nums[i];
            if (freqMap.containsKey(key)) {
                goodPairs += freqMap.get(key);
            }
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
        
        return totalPairs - goodPairs;
}
}