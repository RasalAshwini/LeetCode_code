import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        
        // Convert the board to a string representation
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }
        
        // Valid moves for each position in the 1D representation of the board
        int[][] moves = {
            {1, 3},    // 0
            {0, 2, 4}, // 1
            {1, 5},    // 2
            {0, 4},    // 3
            {1, 3, 5}, // 4
            {2, 4}     // 5
        };
        
        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(start.toString());
        visited.add(start.toString());
        int steps = 0;
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return steps; // Found the solution
                }
                
                // Find the index of '0'
                int zeroIndex = current.indexOf('0');
                
                // Try all possible moves for '0'
                for (int move : moves[zeroIndex]) {
                    String next = swap(current, zeroIndex, move);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }
        
        return -1; // No solution
    }
    
    // Helper method to swap characters in a string
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
