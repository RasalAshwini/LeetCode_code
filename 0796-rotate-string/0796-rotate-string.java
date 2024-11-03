class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths of s and goal are equal
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Check if goal is a substring of s + s
        String doubledS = s + s;
        return doubledS.contains(goal);
    }
}
