import java.util.HashMap;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Count the frequency of each element
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Check if all counts are even
        for (int count : countMap.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}
