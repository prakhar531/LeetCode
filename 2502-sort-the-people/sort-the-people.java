// class Solution {

//     public String[] sortPeople(String[] names, int[] heights) {
//         quickSort(heights, names, 0, heights.length - 1);
//         return names;
//     }

//     private void swap(int[] heights, String[] names, int index1, int index2) {
//         // Swap heights
//         int tempHeight = heights[index1];
//         heights[index1] = heights[index2];
//         heights[index2] = tempHeight;

//         // Swap corresponding names
//         String tempName = names[index1];
//         names[index1] = names[index2];
//         names[index2] = tempName;
//     }

//     private int partition(int[] heights, String[] names, int start, int end) {
//         int pivot = heights[end];
//         int i = start - 1;

//         for (int j = start; j < end; j++) {
//             // If current element is greater than or equal to pivot
//             if (heights[j] >= pivot) {
//                 i++;
//                 swap(heights, names, i, j);
//             }
//         }
//         // Place the pivot in its correct position
//         swap(heights, names, i + 1, end);
//         return i + 1;
//     }

//     private void quickSort(int[] heights, String[] names, int start, int end) {
//         if (start < end) {
//             // Find the partition index
//             int partitionIndex = partition(heights, names, start, end);

//             // Recursively sort the left and right sub-arrays
//             quickSort(heights, names, start, partitionIndex - 1);
//             quickSort(heights, names, partitionIndex + 1, end);
//         }
//     }
// }

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        int numberOfPeople = names.length;

        // Create an array of indices
        Integer[] sortedIndices = new Integer[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedIndices[i] = i;
        }

        // Sort indices based on heights in descending order
        Arrays.sort(sortedIndices, (a, b) -> heights[b] - heights[a]);

        // Apply the sorted indices to rearrange names
        String[] sortedNames = new String[numberOfPeople];
        for (int i = 0; i < numberOfPeople; i++) {
            sortedNames[i] = names[sortedIndices[i]];
        }

        return sortedNames;
    }
}