import java.util.*;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0; // Root is at level 0 (even)

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodesAtCurrentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodesAtCurrentLevel.add(node);

                // Add children to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Reverse values at odd levels
            if (level % 2 == 1) {
                int left = 0, right = nodesAtCurrentLevel.size() - 1;
                while (left < right) {
                    int temp = nodesAtCurrentLevel.get(left).val;
                    nodesAtCurrentLevel.get(left).val = nodesAtCurrentLevel.get(right).val;
                    nodesAtCurrentLevel.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
}
}