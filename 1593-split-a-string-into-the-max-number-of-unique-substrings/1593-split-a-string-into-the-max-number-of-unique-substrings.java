import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> used) {
        // Base case: if we reach the end of the string, return 0 as there are no more substrings to split.
        if (start == s.length()) {
            return 0;
        }
        
        int maxSplits = 0;
        // Try every possible substring starting from the current index 'start'.
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            // If the substring hasn't been used before, consider it.
            if (!used.contains(substring)) {
                used.add(substring);  // Add it to the set
                // Recurse and get the number of splits for the remaining part of the string.
                int splits = 1 + backtrack(s, i, used);
                maxSplits = Math.max(maxSplits, splits);
                used.remove(substring);  // Backtrack and remove the substring from the set
            }
        }
        return maxSplits;
    }
}
