class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        
        while (i < word.length()) {
            char c = word.charAt(i);
            int count = 0;
            
            // Count the occurrences of the character `c`, but only up to 9
            while (i < word.length() && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
            
            // Append the count and the character to the result
            comp.append(count).append(c);
        }
        
        return comp.toString();
    }
}
