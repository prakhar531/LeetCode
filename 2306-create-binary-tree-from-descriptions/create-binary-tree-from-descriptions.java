/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {
        // Sets to track unique children and parents
        Set<Integer> children = new HashSet<>(), parents = new HashSet<>();
        // Map to store parent to children relationships
        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();

        // Build graph from parent to child, and add nodes to HashSets
        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], isLeft = d[2];
            parents.add(parent);
            parents.add(child);
            children.add(child);
            parentToChildren
                .computeIfAbsent(parent, l -> new ArrayList<>())
                .add(new int[] { child, isLeft });
        }

        // Find the root node by checking which node is in parents but not in children
        parents.removeAll(children);
        TreeNode root = new TreeNode(parents.iterator().next());

        // Starting from root, use BFS to construct binary tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            // Iterate over children of current parent
            for (int[] childInfo : parentToChildren.getOrDefault(
                parent.val,
                Collections.emptyList()
            )) {
                int childValue = childInfo[0], isLeft = childInfo[1];
                TreeNode child = new TreeNode(childValue);
                queue.offer(child);
                // Attach child node to its parent based on isLeft flag
                if (isLeft == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }

        return root;
    }
}