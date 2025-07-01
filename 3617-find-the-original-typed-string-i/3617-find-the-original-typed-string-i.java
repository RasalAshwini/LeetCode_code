class Solution {
    public int possibleStringCount(String word) {
        int total = 1; // original string is always valid

        int n = word.length();
        int i = 0;

        while (i < n) {
            int j = i;

            // Find end of current group of same characters
            while (j < n && word.charAt(j) == word.charAt(i)) {
                j++;
            }

            int groupLength = j - i;

            // If group has repeats, we can remove 1 to (groupLength - 1)
            if (groupLength >= 2) {
                total += (groupLength - 1);
            }

            i = j; // move to next group
        }

        return total;
    }
}
