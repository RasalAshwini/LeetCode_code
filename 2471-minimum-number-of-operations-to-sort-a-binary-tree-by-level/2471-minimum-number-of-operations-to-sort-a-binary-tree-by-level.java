import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        
        int totalSwaps = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            
            // Extract the current level's values and enqueue child nodes
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            // Calculate the minimum swaps needed to sort the current level
            totalSwaps += getMinSwaps(levelValues);
        }
        
        return totalSwaps;
    }
    
    private int getMinSwaps(List<Integer> values) {
        int n = values.size();
        int[] sorted = values.stream().sorted().mapToInt(Integer::intValue).toArray();
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexMap.put(values.get(i), i);
        }
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] || sorted[i] == values.get(i)) {
                continue;
            }
            
            int cycleSize = 0;
            int current = i;
            
            while (!visited[current]) {
                visited[current] = true;
                current = indexMap.get(sorted[current]);
                cycleSize++;
            }
            
            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }
        
        return swaps;
}
}
