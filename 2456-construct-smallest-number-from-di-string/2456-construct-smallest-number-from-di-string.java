class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int counter = 1;

        for (int i = 0; i <= n; i++) {
            stack.push((char) ('0' + counter++)); // Push the next number

            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}