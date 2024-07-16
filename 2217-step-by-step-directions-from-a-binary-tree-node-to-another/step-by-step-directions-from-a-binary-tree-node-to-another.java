class Solution {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find the Lowest Common Ancestor (LCA) of start and destination nodes
        TreeNode lowestCommonAncestor = findLowestCommonAncestor(
            root,
            startValue,
            destValue
        );

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        // Find paths from LCA to start and destination nodes
        findPath(lowestCommonAncestor, startValue, pathToStart);
        findPath(lowestCommonAncestor, destValue, pathToDest);

        StringBuilder directions = new StringBuilder();

        // Add "U" for each step to go up from start to LCA
        directions.append("U".repeat(pathToStart.length()));

        // Append the path from LCA to destination
        directions.append(pathToDest);

        return directions.toString();
    }

    private TreeNode findLowestCommonAncestor(
        TreeNode node,
        int value1,
        int value2
    ) {
        if (node == null) return null;

        if (node.val == value1 || node.val == value2) return node;

        TreeNode leftLCA = findLowestCommonAncestor(node.left, value1, value2);
        TreeNode rightLCA = findLowestCommonAncestor(
            node.right,
            value1,
            value2
        );

        if (leftLCA == null) return rightLCA;
        else if (rightLCA == null) return leftLCA;
        else return node; // Both values found, this is the LCA
    }

    private boolean findPath(
        TreeNode node,
        int targetValue,
        StringBuilder path
    ) {
        if (node == null) return false;

        if (node.val == targetValue) return true;

        // Try left subtree
        path.append("L");
        if (findPath(node.left, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        // Try right subtree
        path.append("R");
        if (findPath(node.right, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        return false;
    }
}