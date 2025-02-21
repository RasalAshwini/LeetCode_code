import java.util.Queue;
import java.util.LinkedList;

class FindElements {
    Set<Integer> st = new HashSet<>();

    private void bfs(TreeNode root, int x) {
        Queue<TreeNode> que = new LinkedList<>();
        root.val = x;
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            st.add(temp.val);

            if (temp.left != null) {
                temp.left.val = 2 * temp.val + 1;
                que.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.val = 2 * temp.val + 2;
                que.add(temp.right);
            }
        }
    }

    public FindElements(TreeNode root) {
        st.clear();
        bfs(root, 0);
    }

    public boolean find(int target) {
        return st.contains(target);
    }
}