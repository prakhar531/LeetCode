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
// class Solution {

//     public TreeNode createBinaryTree(int[][] descriptions) {
//         // Sets to track unique children and parents
//         Set<Integer> children = new HashSet<>(), parents = new HashSet<>();
//         // Map to store parent to children relationships
//         Map<Integer, List<int[]>> parentToChildren = new HashMap<>();

//         // Build graph from parent to child, and add nodes to HashSets
//         for (int[] d : descriptions) {
//             int parent = d[0], child = d[1], isLeft = d[2];
//             parents.add(parent);
//             parents.add(child);
//             children.add(child);
//             parentToChildren
//                 .computeIfAbsent(parent, l -> new ArrayList<>())
//                 .add(new int[] { child, isLeft });
//         }

//         // Find the root node by checking which node is in parents but not in children
//         parents.removeAll(children);
//         TreeNode root = new TreeNode(parents.iterator().next());

//         // Starting from root, use BFS to construct binary tree
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             TreeNode parent = queue.poll();
//             // Iterate over children of current parent
//             for (int[] childInfo : parentToChildren.getOrDefault(
//                 parent.val,
//                 Collections.emptyList()
//             )) {
//                 int childValue = childInfo[0], isLeft = childInfo[1];
//                 TreeNode child = new TreeNode(childValue);
//                 queue.offer(child);
//                 // Attach child node to its parent based on isLeft flag
//                 if (isLeft == 1) {
//                     parent.left = child;
//                 } else {
//                     parent.right = child;
//                 }
//             }
//         }

//         return root;
//     }
// }

// class Solution {

//     public TreeNode createBinaryTree(int[][] descriptions) {
//         // Step 1: Organize data
//         Map<Integer, List<int[]>> parentToChildren = new HashMap<>();
//         Set<Integer> allNodes = new HashSet<>();
//         Set<Integer> children = new HashSet<>();

//         for (int[] desc : descriptions) {
//             int parent = desc[0];
//             int child = desc[1];
//             int isLeft = desc[2];

//             // Store child information under parent node
//             if (!parentToChildren.containsKey(parent)) {
//                 parentToChildren.put(parent, new ArrayList<>());
//             }
//             parentToChildren.get(parent).add(new int[] { child, isLeft });
//             allNodes.add(parent);
//             allNodes.add(child);
//             children.add(child);
//         }

//         // Step 2: Find the root
//         int rootVal = 0;
//         for (int node : allNodes) {
//             if (!children.contains(node)) {
//                 rootVal = node;
//                 break;
//             }
//         }

//         // Step 3 & 4: Build the tree using DFS
//         return dfs(parentToChildren, rootVal);
//     }

//     // DFS function to recursively build binary tree
//     private TreeNode dfs(Map<Integer, List<int[]>> parentToChildren, int val) {
//         // Create new TreeNode for current value
//         TreeNode node = new TreeNode(val);

//         // If current node has children, recursively build them
//         if (parentToChildren.containsKey(val)) {
//             for (int[] childInfo : parentToChildren.get(val)) {
//                 int child = childInfo[0];
//                 int isLeft = childInfo[1];

//                 // Attach child node based on isLeft flag
//                 if (isLeft == 1) {
//                     node.left = dfs(parentToChildren, child);
//                 } else {
//                     node.right = dfs(parentToChildren, child);
//                 }
//             }
//         }
//         return node;
//     }
// }

// class Solution {
//     public TreeNode createBinaryTree(int[][] descriptions) {
       
//         Map<Integer,TreeNode> map=new HashMap<>();
//         Set<Integer> children = new HashSet<>();

//         for (int[] desc : descriptions) {
//             int parent = desc[0];
//             int child = desc[1];
//             boolean isLeft = desc[2]==1;

//             if (!map.containsKey(parent)) {
//                 map.put(parent, new TreeNode(parent));
//             }
//             if (!map.containsKey(child)) {
//                 map.put(child, new TreeNode(child));
//             }
//             children.add(child);
//             if(isLeft){
//                 map.get(parent).left=map.get(child);
//             }else{
//                 map.get(parent).right=map.get(child);
//             }

//         }
//         int root=0;
//         for(int key:map.keySet()){
//                 if(!children.contains(key)){
//                     root=key;
//                     break;
//                 }
//         }

//         return map.get(root);

//     }
// }

class Solution {

    public TreeNode createBinaryTree(int[][] descriptions) {
        // Maps values to TreeNode pointers
        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        // Stores values which are children in the descriptions
        Set<Integer> children = new HashSet<>();

        // Iterate through descriptions to create nodes and set up tree structure
        for (int[] description : descriptions) {
            // Extract parent value, child value, and whether it is a
            // left child (1) or right child (0)
            int parentValue = description[0];
            int childValue = description[1];
            boolean isLeft = description[2] == 1;

            // Create parent and child nodes if not already created
            if (!nodeMap.containsKey(parentValue)) {
                nodeMap.put(parentValue, new TreeNode(parentValue));
            }
            if (!nodeMap.containsKey(childValue)) {
                nodeMap.put(childValue, new TreeNode(childValue));
            }

            // Attach child node to parent's left or right branch
            if (isLeft) {
                nodeMap.get(parentValue).left = nodeMap.get(childValue);
            } else {
                nodeMap.get(parentValue).right = nodeMap.get(childValue);
            }

            // Mark child as a child in the set
            children.add(childValue);
        }

        // Find and return the root node
        for (TreeNode node : nodeMap.values()) {
            if (!children.contains(node.val)) {
                return node; // Root node found
            }
        }

        return null; // Should not occur according to problem statement
    }
}