class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int l = 0;
        int limit = n + k - 1;
        
        while (l < n) {
            // Find largest valid window
            int r = l + 1;
            while (r < limit && colors[(r - 1) % n] != colors[r % n]) {
                r++;
            }

            // Count Valid Windows
            if (r - l >= k) {
                count += (r - l) - k + 1;
            }
            l = r;
        }
        return count;
}
}