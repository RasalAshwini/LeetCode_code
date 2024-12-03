class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0; // Pointer for the spaces array
        int n = spaces.length;

        for (int i = 0; i < s.length(); i++) {
            // If the current index matches a space index, add a space
            if (spaceIndex < n && i == spaces[spaceIndex]) {
                result.append(" ");
                spaceIndex++; // Move to the next space index
            }
            // Append the current character
            result.append(s.charAt(i));
        }

        return result.toString();
}
}