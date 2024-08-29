class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(20002); // Initialize UnionFind with a large enough range to handle coordinates

        // Union stones that share the same row or column
        for (int i = 0; i < n; i++) {
            uf.union(stones[i][0], stones[i][1] + 10001); // Offset y-coordinates to avoid conflict with x-coordinates
        }

        return n - uf.componentCount;
    }

    // Union-Find data structure for tracking connected components
    class UnionFind {

        int[] parent; // Array to track the parent of each node
        int componentCount; // Number of connected components
        Set<Integer> uniqueNodes; // Set to track unique nodes

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1); // Initialize all nodes as their own parent
            componentCount = 0;
            uniqueNodes = new HashSet<>();
        }

        // Find the root of a node with path compression
        int find(int node) {
            // If node is not marked, increase the component count
            if (!uniqueNodes.contains(node)) {
                componentCount++;
                uniqueNodes.add(node);
            }

            if (parent[node] == -1) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        // Union two nodes, reducing the number of connected components
        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2) {
                return; // If they are already in the same component, do nothing
            }

            // Merge the components and reduce the component count
            parent[root1] = root2;
            componentCount--;
        }
    }
}