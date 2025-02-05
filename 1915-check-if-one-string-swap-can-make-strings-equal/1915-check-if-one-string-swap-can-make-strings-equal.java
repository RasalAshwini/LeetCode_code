class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;  // Different lengths → Not possible

        int first = -1, second = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count > 2) return false;  // More than 2 mismatches → Not possible

                if (first == -1) first = i;   // Store first mismatch index
                else second = i;              // Store second mismatch index
            }
        }

        // If there are no mismatches, return true (they are already equal)
        if (count == 0) return true;

        // If exactly two mismatches, check if swapping makes them equal
        return count == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}
