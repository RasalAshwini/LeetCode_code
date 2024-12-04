class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int i = 0, j = 0;

        // Two-pointer approach
        while (i < n && j < m) {
            char currentChar = str1.charAt(i);
            char nextChar = (char) ((currentChar - 'a' + 1) % 26 + 'a'); // Calculate next cyclic character
            
            // Check if we can match the current character of str2
            if (currentChar == str2.charAt(j) || nextChar == str2.charAt(j)) {
                j++; // Move to the next character in str2
            }
            i++; // Move to the next character in str1
        }

        // If all characters in str2 are matched, return true
        return j==m;
}
}