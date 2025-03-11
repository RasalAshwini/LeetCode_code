class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // To count 'a', 'b', and 'c'
        int i = 0, result = 0;

        for (int j = 0; j < n; j++) {
            // Increment the count of the current character
            count[s.charAt(j) - 'a']++;
            
            // Check if the window is valid (contains 'a', 'b', 'c')
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // Count all valid substrings starting from index i to end of string
                result += n - j;
                
                // Shrink the window from the left
                count[s.charAt(i) - 'a']--;
                i++;
            }
        }
        
        return result;
    }
}
