class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(nums);
        
        int maxStreak = 0;

        for (int num : nums) {
            int root = (int) Math.sqrt(num);

            if (root * root == num && mp.containsKey(root)) {
                mp.put(num, mp.get(root) + 1);
            } else {
                mp.put(num, 1);
            }

            maxStreak = Math.max(maxStreak, mp.get(num));
        }

        return maxStreak < 2 ? -1 : maxStreak;
 }
}