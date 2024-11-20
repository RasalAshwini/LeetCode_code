class Solution {
    public int takeCharacters(String s, int k) {
        // Count the total frequency of 'a', 'b', and 'c'
        int[] freq = new int[3];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // If any character's frequency is less than k, return -1
        if (freq[0] < k || freq[1] < k || freq[2] < k) {
            return -1;
        }
        
        int n = s.length();
        int maxWindowLength = 0;
        int[] windowFreq = new int[3];
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            // Add the current character to the window frequency
            windowFreq[s.charAt(right) - 'a']++;
            
            // Shrink the window if it violates the condition of leaving enough characters outside
            while (freq[0] - windowFreq[0] < k || freq[1] - windowFreq[1] < k || freq[2] - windowFreq[2] < k) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }
            
            // Update the maximum length of the valid window
            maxWindowLength = Math.max(maxWindowLength, right - left + 1);
        }
        
        // Calculate the minimum number of characters to take
        return n - maxWindowLength;
    }
}
